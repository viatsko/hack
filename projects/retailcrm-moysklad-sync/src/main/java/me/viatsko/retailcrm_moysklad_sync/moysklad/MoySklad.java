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

package me.viatsko.retailcrm_moysklad_sync.moysklad;

import com.google.gson.Gson;
import me.viatsko.retailcrm_moysklad_sync.Config;
import me.viatsko.retailcrm_moysklad_sync.entity.moysklad.*;
import me.viatsko.retailcrm_moysklad_sync.gson.builder.GsonBuilderFactory;
import me.viatsko.retailcrm_moysklad_sync.util.DateUtils;
import me.viatsko.retailcrm_moysklad_sync.util.UrlUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MoySklad {
    private static final Logger log = Logger.getLogger(MoySklad.class.getName());

    private static final String HOST_URL = "https://online.moysklad.ru/api/remap/1.1";

    private static final String API_ORDERS = "/entity/customerorder";

    private static final String API_PRODUCTS = "/entity/product";

    private static final String API_COUNTERPARTIES = "/entity/counterparty";

    private static final String API_DEMANDS = "/entity/demand";

	private static final Gson gson = GsonBuilderFactory.getGsonBuilder("mysql").create();

    private Config config;

    public MoySklad(Config config) {
        this.config = config;
    }

	public MoySkladCreateCounterPartyResponse createCounterParty(
			MoySkladCreateCounterPartyRequest createCounterPartyRequest
	) throws Exception {
    	String json = gson.toJson(createCounterPartyRequest);

    	System.out.println(json);

    	return gson.fromJson(
    			UrlUtils.postUrl(
						HOST_URL +
								API_COUNTERPARTIES,
						config.getMoySkladUsername(),
						config.getMoySkladPassword(),
						json
				),
				MoySkladCreateCounterPartyResponse.class
		);
	}

	public MoySkladCreateOrderResponse createOrder(
			MoySkladCreateOrderRequest createOrderRequest
	) throws Exception {
		String json = gson.toJson(createOrderRequest);

		System.out.println(json);

		return gson.fromJson(
				UrlUtils.postUrl(
						HOST_URL +
								API_ORDERS,
						config.getMoySkladUsername(),
						config.getMoySkladPassword(),
						json
				),
				MoySkladCreateOrderResponse.class
		);
	}

	public MoySkladUpdateOrderResponse updateOrder(
			String id,
			MoySkladUpdateOrderRequest updateOrderRequest
	) throws Exception {
		String json = gson.toJson(updateOrderRequest);

		System.out.println(json);

		return gson.fromJson(
				UrlUtils.putUrl(
						HOST_URL +
								API_ORDERS +
								"/" + id,
						config.getMoySkladUsername(),
						config.getMoySkladPassword(),
						json
				),
				MoySkladUpdateOrderResponse.class
		);
	}

    public List<MoySkladOrder> getOrders() throws Exception {
		List<MoySkladOrder> result = new ArrayList<>();

		int currentOffset = 0;

		int maxCount = Integer.MAX_VALUE;

		while(currentOffset < maxCount) {
			MoySkladOrdersResponse moySkladOrdersResponse = gson.fromJson(
					UrlUtils.getUrl(
							HOST_URL +
									API_ORDERS +
									"?limit=100&offset=" + currentOffset,
							config.getMoySkladUsername(),
							config.getMoySkladPassword()
					),
					MoySkladOrdersResponse.class
			);

			log.info("Orders offset at " + currentOffset);

			result.addAll(moySkladOrdersResponse.getRows());

			if (currentOffset == 0) {
				// we are only looking up in last 500 orders
				currentOffset = moySkladOrdersResponse.getMeta().getSize() - 100;
			} else {
				currentOffset += 100;
			}

			maxCount = moySkladOrdersResponse.getMeta().getSize();
		}

		return result;
    }

	public MoySkladCreateDemandResponse createDemand(
			MoySkladCreateDemandRequest createDemandRequest
	) throws Exception {
		String json = gson.toJson(createDemandRequest);

		System.out.println(json);

		return gson.fromJson(
				UrlUtils.postUrl(
						HOST_URL +
								API_DEMANDS,
						config.getMoySkladUsername(),
						config.getMoySkladPassword(),
						json
				),
				MoySkladCreateDemandResponse.class
		);
	}

    public List<MoySkladProduct> getProducts(boolean onlyRecentMode) throws Exception {
        List<MoySkladProduct> result = new ArrayList<>();

        int currentOffset = 0;

        int maxCount = Integer.MAX_VALUE;

        while(currentOffset < maxCount) {
            MoySkladProductsResponse moySkladProductsResponse = gson.fromJson(
                    UrlUtils.getUrl(
                            HOST_URL +
                                    API_PRODUCTS +
                                    "?limit=100&offset=" + currentOffset +
									(onlyRecentMode ? ("&updatedFrom=" + URLEncoder.encode(DateUtils.getMySQLDateDayAgo(2), "UTF-8")) : ""),
                            config.getMoySkladUsername(),
                            config.getMoySkladPassword()
                    ),
                    MoySkladProductsResponse.class
            );

            log.info("Products offset at " + currentOffset);

            result.addAll(moySkladProductsResponse.getRows());

            currentOffset += 100;

            maxCount = moySkladProductsResponse.getMeta().getSize();
        }

        return result;
    }

    public List<MoySkladCounterParty> getCounterParties(boolean onlyRecentMode) throws Exception {
        List<MoySkladCounterParty> result = new ArrayList<>();

        int currentOffset = 0;

        int maxCount = Integer.MAX_VALUE;

        while(currentOffset < maxCount) {
            MoySkladCounterPartiesResponse moySkladCounterPartiesResponse = gson.fromJson(
                    UrlUtils.getUrl(
                            HOST_URL +
                                    API_COUNTERPARTIES +
                                    "?limit=100&offset=" + currentOffset +
									(onlyRecentMode ? ("&updatedFrom=" + URLEncoder.encode(DateUtils.getMySQLDateDayAgo(2), "UTF-8")) : ""),
                            config.getMoySkladUsername(),
                            config.getMoySkladPassword()
                    ),
                    MoySkladCounterPartiesResponse.class
            );

            log.info("CounterParties offset at " + currentOffset);

            result.addAll(moySkladCounterPartiesResponse.getRows());

			currentOffset += 100;

            maxCount = moySkladCounterPartiesResponse.getMeta().getSize();
        }

        return result;
    }
}
