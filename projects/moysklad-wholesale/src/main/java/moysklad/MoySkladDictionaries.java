package moysklad;

import gson.entity.moysklad.MoySkladProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MoySkladDictionaries {
    private static final Logger log = Logger.getLogger(MoySkladDictionaries.class.getName());

    private static Map<String, MoySkladProduct> fetchProducts(MoySklad moySklad) throws Exception {
        log.info("Fetching products...");

        List<MoySkladProduct> productList = moySklad.getProducts();

        log.info("Fetched " + productList.size() + " products");

        Map<String, MoySkladProduct> productHash = new HashMap<>();

        for (MoySkladProduct product : productList) {
            productHash.put(product.getExternalCode(), product);
        }

        return productHash;
    }

    public static void updateProductsMap(MoySklad moySklad, Map<String, MoySkladProduct> productsMap) throws Exception {
        try {
            Map<String, MoySkladProduct> products = fetchProducts(moySklad);

            productsMap.clear();
            productsMap.putAll(products);

            log.info("Products map updated");
        } catch (Exception e) {
            productsMap.clear();
            System.out.println(e);
            throw new Exception("Error loading products map.");
        }
    }
}
