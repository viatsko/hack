import bitrix.Bitrix;
import bitrix.BitrixDictionaries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import config.Config;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.entity.PathName;
import freemarker.entity.PathNameTreeNode;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import gson.entity.api.endpoints.GetPriceTypesResponse;
import gson.entity.api.endpoints.GetProductsByPriceTypeResponse;
import gson.entity.moysklad.MoySkladProduct;
import gson.entity.moysklad.MoySkladProductSalePrice;
import gson.entity.retailcrm.RetailCRMOrder;
import gson.entity.retailcrm.RetailCRMOrderItem;
import gson.entity.retailcrm.RetailCRMOrderItemOffer;
import moysklad.MoySklad;
import moysklad.MoySkladDictionaries;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import retailcrm.RetailCRM;
import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;
import sql2o.Model;
import sql2o.Sql2oModel;
import sql2o.entity.Order;
import sql2o.entity.User;
import util.StringUtils;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;

public class Main implements SparkApplication {
    private final Map<String, MoySkladProduct> productsMap = new ConcurrentHashMap<>();
    private final Map<String, String> availableProductsMap = new ConcurrentHashMap<>();

    private static <T> T Copy(T AnObject, Class<T> ClassInfo)
    {
        Gson gson = new GsonBuilder().create();
        String text = gson.toJson(AnObject);
        return gson.fromJson(text, ClassInfo);
    }

    private List<MoySkladProduct> getProductsByPriceType(String type) {
        List<MoySkladProduct> products = new ArrayList<>();

        for (Map.Entry<String, MoySkladProduct> entry : productsMap.entrySet()) {
            MoySkladProduct product = entry.getValue();

            if (!availableProductsMap.containsKey(product.getExternalCode())) {
                continue;
            }

            if (product.getPathName() == null || product.getPathName().length() == 0) {
                continue;
            }

            List<MoySkladProductSalePrice> salePrices = product.getSalePrices();

            if (salePrices == null) continue;

            for (MoySkladProductSalePrice salePrice : salePrices) {
                if (salePrice.getPriceType().equals(type)) {
                    if (salePrice.getValue() == null || salePrice.getValue() == 0) {
                        continue;
                    }

                    MoySkladProduct cloned = Copy(product, MoySkladProduct.class);

                    cloned.setImageUrl(availableProductsMap.get(product.getExternalCode()));

                    cloned.setMeta(null);

                    cloned.setSalePrices(new ArrayList<MoySkladProductSalePrice>(){{ add(salePrice); }});

                    String pathName = cloned.getPathName();

                    pathName = pathName.substring(pathName.indexOf('/') + 1).replace("/", " / ");

                    cloned.setPathName(pathName);

                    products.add(cloned);

                    break;
                }
            }
        }

        return products;
    }

    public static void main(String[] args) {
        new Main().init();
    }

    @Override
    public void init() {
        try {
            Class.forName("org.sqlite.JDBC");

            Config config = new Config();

            MoySklad moySklad = new MoySklad(config);

            RetailCRM retailCRM = new RetailCRM(config);

            Bitrix bitrix = new Bitrix(config);

            MoySkladDictionaries.updateProductsMap(moySklad, productsMap);
            BitrixDictionaries.updateAvailableProductsMap(bitrix, availableProductsMap);

            FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
            Configuration freeMarkerConfiguration = new Configuration();
            freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Main.class, "/templates"));

            freeMarkerConfiguration.setCacheStorage(new NullCacheStorage());

            freeMarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            freeMarkerEngine.setConfiguration(freeMarkerConfiguration);

            try {
                freeMarkerConfiguration.getTemplate("index.ftl");
            } catch (Exception e) {
                e.getMessage();
            }

            // null, null is used here because single param constructor is for jndi object
            // while this one uses first param as a jdbc connection string
            Sql2o sql2o = new Sql2o("jdbc:sqlite:wholesale.db", null, null);

            Model model = new Sql2oModel(sql2o);

            Connection connection = sql2o.open();

            connection.createQuery(User.CREATE_TABLE).executeUpdate();

            connection.createQuery(Order.CREATE_TABLE).executeUpdate();

            if (model.getUsersCount() == 0) {
                model.createUser("admin", "admin", "");
            }

            // root is 'src/main/resources', so put files in 'src/main/resources/public'
            staticFiles.location("/public");

            before("/*", (req, res) -> {
                if (!req.uri().startsWith("/updateProducts")) {
                    Boolean authenticated = false;

                    String auth = req.headers("Authorization");

                    if (auth != null && auth.startsWith("Basic")) {
                        String b64Credentials = auth.substring("Basic".length()).trim();

                        String credentials = new String(Base64.getDecoder().decode(b64Credentials));

                        String[] credentiasParts = credentials.split(":");

                        if (credentiasParts.length > 1 && model.isUserExists(credentiasParts[0], credentiasParts[1])) {
                            authenticated = true;

                            req.attribute("email", credentiasParts[0]);
                        }
                    }

                    if (!authenticated) {
                        res.header("WWW-Authenticate", "Basic realm=\"Restricted\"");

                        halt(401, "У вас нет доступа к данному разделу.");
                    }
                }
            });

            get("/", (req, res) -> {
                res.status(200);
                res.type("text/html");

                List<MoySkladProduct> products = getProductsByPriceType(config.getMoySkladPriceType());
                products.sort(Comparator.comparing(MoySkladProduct::getPathName));

                PathNameTreeNode root = new PathNameTreeNode();

                for (MoySkladProduct product : products) {
                    String[] pathParts = product.getPathName().split(" / ");

                    PathNameTreeNode node = root;

                    int currentDepth = 0;

                    StringBuilder sb = new StringBuilder();

                    for (String pathPart : pathParts) {
                        if (sb.length() == 0) {
                            sb.append(pathPart);
                        } else {
                            sb.append(" / ").append(pathPart);
                        }

                        pathPart = pathPart.trim();

                        if (!node.getChildren().containsKey(pathPart)) {
                            PathName pathName = new PathName(currentDepth, pathPart, sb.toString());

                            PathNameTreeNode child = new PathNameTreeNode(pathName);

                            node.getChildren().put(pathPart, child);

                            node = child;
                        } else {
                            node = node.getChildren().get(pathPart);
                        }

                        currentDepth++;
                    }
                }

                List<PathName> pathNames = new LinkedList<>();

                Stack<PathNameTreeNode> stack = new Stack<>();
                stack.add(root);

                while (!stack.isEmpty()) {
                    PathNameTreeNode node = stack.pop();

                    if (node.getValue() != null) {
                        pathNames.add(node.getValue());
                    }

                    Stack<PathNameTreeNode> tmp = new Stack<>();

                    for (Map.Entry<String, PathNameTreeNode> entry : node.getChildren().entrySet()) {
                        tmp.push(entry.getValue());
                    }

                    while (!tmp.isEmpty()) {
                        stack.push(tmp.pop());
                    }
                }

                Map<String, Object> attributes = new HashMap<>();
                attributes.put("products", products);
                attributes.put("baseUrl", config.getBitrixBaseUrl());
                attributes.put("currentPathName", "");
                attributes.put("pathNames", pathNames);
                attributes.put("catalogName", config.getBrandingCatalogName());
                attributes.put("catalogText", config.getBrandingCatalogText());

                return freeMarkerEngine.render(new ModelAndView(attributes, "/index.ftl"));
            });

            /*
             * TODO add authorization check
             */
            get("/getProductsByPriceType", (req, res) -> {
                res.status(200);
                res.type("application/json");

                Gson gson = new Gson();

                String type = req.queryParams("type");

                if (type == null || type.equals("")) {
                    return null;
                }

                List<MoySkladProduct> products = getProductsByPriceType(type);

                return gson.toJson(new GetProductsByPriceTypeResponse.GetProductsByPriceTypeResponseBuilder().withProducts(products).build());
            });

            get("/getPriceTypes", (req, res) -> {
                res.status(200);
                res.type("application/json");

                Gson gson = new Gson();

                Set<String> set = new HashSet<>();

                for (Map.Entry<String, MoySkladProduct> entry : productsMap.entrySet()) {
                    MoySkladProduct product = entry.getValue();

                    List<MoySkladProductSalePrice> salePrices = product.getSalePrices();

                    if (salePrices == null) continue;

                    for (MoySkladProductSalePrice salePrice : salePrices) {
                        set.add(salePrice.getPriceType());
                    }
                }

                List<String> priceTypes = new ArrayList<>(set);

                return gson.toJson(new GetPriceTypesResponse.GetPriceTypesResponseBuilder()
                        .withPriceTypes(priceTypes)
                        .build());
            });

            get("/updateProducts", (req, res) -> {
                res.status(200);
                res.type("application/json");

                MoySkladDictionaries.updateProductsMap(moySklad, productsMap);
                BitrixDictionaries.updateAvailableProductsMap(bitrix, availableProductsMap);

                return "{\"status\":\"ok\"}";
            });

            get("/thankYou", (req, res) -> freeMarkerEngine.render(new ModelAndView(new HashMap<>(), "/thankYou.ftl")));

            get("/users", (req, res) -> {
                String email = req.attribute("email");

                if (!email.equals("admin")) {
                    return "";
                }

                Map<String, Object> attributes = new HashMap<>();

                attributes.put("users", model.getAllUsers());

                return freeMarkerEngine.render(new ModelAndView(attributes, "/users.ftl"));
            });

            get("/userDelete", (req, res) -> {
                String email = req.attribute("email");

                if (!email.equals("admin")) {
                    return "";
                }

                String emailParam = req.queryParams("email");

                if (emailParam != null && !emailParam.equals("admin")) {
                    model.deleteUser(emailParam);
                }

                res.redirect("/users");

                return "";
            });

            post("/userAdd", (req, res) -> {
                String email = req.attribute("email");

                if (!email.equals("admin")) {
                    return "";
                }

                String emailParam = req.queryParams("email");
                String passwordParam = req.queryParams("password");

                if (emailParam != null && passwordParam != null && !emailParam.equals("")) {
                    model.createUser(emailParam, passwordParam, "");
                }

                res.redirect("/users");

                return "";
            });

            post("/adminPassChange", (req, res) -> {
                String email = req.attribute("email");

                if (!email.equals("admin")) {
                    return "";
                }
                String passwordParam = req.queryParams("password");

                if (passwordParam != null) {
                    model.updateUserPassword("admin", passwordParam);
                }

                res.redirect("/users");

                return "";
            });

            post("/submitOrder", (req, res) -> {
                res.status(200);
                res.type("text/html");

                QueryParamsMap map = req.queryMap();

                try {
                    Gson gson = new Gson();

                    Type stringIntegerMap = new TypeToken<Map<String, Integer>>() {
                    }.getType();

                    String rawOrder = map.get("order").value();

                    Map<String, Integer> orderProducts = gson.fromJson(rawOrder, stringIntegerMap);

                    String contactName = map.get("contactName").value();

                    String phone = map.get("phone").value();

                    String email = map.get("email").value();

                    String city = map.get("city").value();

                    String address = map.get("address").value();

                    String description = map.get("description").value();

                    Integer orderId;

                    if (model.getOrdersCount() == 0) {
                        orderId = config.getRetailCRMWholesaleOrderStartNum();
                    } else {
                        orderId = model.getOrdersMaxId() + 1;
                    }

                    model.createOrder(
                            orderId,
                            contactName,
                            phone,
                            email,
                            city,
                            address,
                            description,
                            rawOrder
                    );

                    String priceType = config.getMoySkladPriceType();

                    List<RetailCRMOrderItem> orderItems = new ArrayList<>();

                    for (Map.Entry<String, Integer> entry : orderProducts.entrySet()) {
                        String xmlId = entry.getKey();

                        if (!availableProductsMap.containsKey(xmlId)) {
                            continue;
                        }

                        Integer quantity = entry.getValue();

                        MoySkladProduct product = productsMap.get(xmlId);

                        RetailCRMOrderItemOffer offer = new RetailCRMOrderItemOffer.RetailCRMOrderItemOfferBuilder()
                                .withXmlId(xmlId)
                                .build();


                        Double initialPrice = 0.0;
                        for (MoySkladProductSalePrice price : product.getSalePrices()) {
                            if (price.getPriceType().equals(priceType)) {
                                initialPrice = price.getValue() / 100;
                            }
                        }


                        RetailCRMOrderItem item = new RetailCRMOrderItem.RetailCRMOrderItemBuilder()
                                .withOffer(offer)
                                .withInitialPrice(initialPrice)
                                .withQuantity((double) quantity)
                                .build();

                        orderItems.add(item);
                    }

                    RetailCRMOrder.RetailCRMOrderBuilder orderBuilder = new RetailCRMOrder.RetailCRMOrderBuilder();

                    orderBuilder.withItems(orderItems);

                    String[] contactNameParts = contactName.trim().split("\\s+");

                    if (contactNameParts.length > 2) {
                        orderBuilder.withPatronymic(contactNameParts[2]);
                    } else {
                        orderBuilder.withPatronymic("");
                    }

                    if (contactNameParts.length > 1) {
                        orderBuilder.withFirstName(contactNameParts[1]);
                    } else {
                        orderBuilder.withFirstName("");
                    }

                    if (contactNameParts.length > 0) {
                        orderBuilder.withLastName(contactNameParts[0]);
                    } else {
                        orderBuilder.withLastName("");
                    }

                    orderBuilder.withStatus("new");

                    orderBuilder.withCustomerComment(city + ", " + address + "\n\n" + description);

                    orderBuilder.withNumber("W" + StringUtils.leftPad(String.valueOf(orderId), 5));

                    if (phone != null) {
                        orderBuilder.withPhone(phone);
                    } else {
                        orderBuilder.withPhone("");
                    }

                    if (email != null) {
                        orderBuilder.withEmail(email);
                    } else {
                        orderBuilder.withEmail("");
                    }

                    RetailCRMOrder order = orderBuilder.build();

                    retailCRM.createOrder(order);

                    return "OK";
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
