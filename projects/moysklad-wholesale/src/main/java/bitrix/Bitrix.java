package bitrix;

import com.google.gson.Gson;
import config.Config;
import gson.builder.GsonBuilderFactory;
import gson.entity.bitrix.GetAvailableProductsImagesResponse;
import moysklad.MoySklad;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.logging.Logger;

public class Bitrix {
    private static final Logger log = Logger.getLogger(MoySklad.class.getName());

    private static final Gson gson = GsonBuilderFactory.getGsonBuilder("mysql").create();

    private Config config;

    public Bitrix(Config config) {
        this.config = config;
    }

    public Map<String, String> getAvailableProductsImages() throws IOException {
        Gson gson = new Gson();

        GetAvailableProductsImagesResponse getAvailableProductsImagesResponse =
                gson.fromJson(
                        Request.Get(
                                config.getBitrixAvailableProductsEndPoint()
                        )
                                .execute()
                                .returnContent()
                                .asString(Charset.forName("UTF-8")),
                        GetAvailableProductsImagesResponse.class
                );

        return getAvailableProductsImagesResponse.getProducts();
    }
}
