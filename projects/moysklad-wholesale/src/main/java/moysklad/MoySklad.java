package moysklad;

import com.google.gson.Gson;
import config.Config;
import gson.builder.GsonBuilderFactory;
import gson.entity.moysklad.MoySkladProduct;
import gson.entity.moysklad.MoySkladProductsResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.fluent.Request;
import util.DateUtils;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MoySklad {
    private static final Logger log = Logger.getLogger(MoySklad.class.getName());

    private static final String HOST_URL = "https://online.moysklad.ru/api/remap/1.1";

    private static final String API_PRODUCTS = "/entity/product";

    private static final Gson gson = GsonBuilderFactory.getGsonBuilder("mysql").create();

    private Config config;

    public MoySklad(Config config) {
        this.config = config;
    }

    public List<MoySkladProduct> getProducts() throws Exception {
        List<MoySkladProduct> result = new ArrayList<>();

        int currentOffset = 0;

        int maxCount = Integer.MAX_VALUE;

        String auth = config.getMoySkladUsername() + ":" + config.getMoySkladPassword();
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        while(currentOffset < maxCount) {
            MoySkladProductsResponse moySkladProductsResponse = gson.fromJson(
                    Request.Get(
                                HOST_URL +
                                API_PRODUCTS +
                                "?limit=100&offset=" +
                                currentOffset
                            )
                            .addHeader(HttpHeaders.AUTHORIZATION, authHeader)
                            .execute()
                            .returnContent()
                            .asString(Charset.forName("UTF-8")),
                    MoySkladProductsResponse.class
            );

            log.info("Products offset at " + currentOffset);

            result.addAll(moySkladProductsResponse.getRows());

            currentOffset += 100;

            maxCount = moySkladProductsResponse.getMeta().getSize();
        }

        return result;
    }
}
