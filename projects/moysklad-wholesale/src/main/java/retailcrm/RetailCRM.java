package retailcrm;

import com.google.gson.Gson;
import config.Config;
import gson.entity.retailcrm.RetailCRMOrder;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class RetailCRM {
    private static final String API_ORDERS = "/api/v5/orders";

    private Config config;

    public RetailCRM(Config config) {
        this.config = config;
    }

    public void createOrder(RetailCRMOrder order) throws IOException {
        Gson gson = new Gson();

        System.out.println(Request.Post(config.getRetailCRMURI() + API_ORDERS + "/create")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .bodyForm(
                        Form.form()
                            .add("apiKey", config.getRetailCRMKey())
                            .add("site", config.getRetailCRMSiteId())
                            .add("order", gson.toJson(order))
                            .build(),
                        Consts.UTF_8
                )
                .execute()
                .returnContent()
                .asString(
                        Charset.forName("UTF-8")
                ));
    }
}
