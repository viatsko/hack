/*-
 * -\-\-
 * retailcrm-moysklad-sync
 * --
 * Copyright (C) 2017 Valerii Iatsko
 * --
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * -/-/-
 */

package me.viatsko.retailcrm_moysklad_sync.retailcrm;

import com.google.gson.Gson;
import me.viatsko.retailcrm_moysklad_sync.Config;
import me.viatsko.retailcrm_moysklad_sync.entity.retailcrm.RetailCRMOrdersHistoryResponse;
import me.viatsko.retailcrm_moysklad_sync.entity.retailcrm.RetailCRMOrdersResponse;
import me.viatsko.retailcrm_moysklad_sync.gson.builder.GsonBuilderFactory;
import me.viatsko.retailcrm_moysklad_sync.util.DateUtils;
import me.viatsko.retailcrm_moysklad_sync.util.UrlUtils;

import java.net.URLEncoder;

public class RetailCRM {
    private static final String API_ORDERS = "/api/v5/orders";
    private static final String API_ORDERS_HISTORY = "/api/v5/orders/history";

    private Config config;

    public RetailCRM(Config config) {
        this.config = config;
    }

    public RetailCRMOrdersResponse getOrders() throws Exception {
        Gson gson = GsonBuilderFactory.getGsonBuilder("mysql").create();

        return gson.fromJson(
                UrlUtils.getUrl(
                        config.getRetailCRMURI() +
                        API_ORDERS +
                        "?apiKey=" +
                        config.getRetailCRMKey() +
                        "&limit=100"
                ),
                RetailCRMOrdersResponse.class
        );
    }

    public RetailCRMOrdersHistoryResponse getOrdersHistory() throws Exception {
        Gson gson = GsonBuilderFactory.getGsonBuilder("mysql").create();

        return gson.fromJson(
                UrlUtils.getUrl(
                        config.getRetailCRMURI() +
                                API_ORDERS_HISTORY +
                                "?apiKey=" +
                                config.getRetailCRMKey() +
                                "&filter[startDate]=" +
								URLEncoder.encode(DateUtils.getMySQLDateDayAgo(1), "UTF-8") +
                                "&limit=100"
                ),
                RetailCRMOrdersHistoryResponse.class
        );
    }
}
