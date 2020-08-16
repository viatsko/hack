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

import me.viatsko.retailcrm_moysklad_sync.entity.moysklad.MoySkladCounterParty;
import me.viatsko.retailcrm_moysklad_sync.entity.moysklad.MoySkladProduct;
import org.mapdb.DB;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MoySkladDictionaries {
	private static final Logger log = Logger.getLogger(MoySkladDictionaries.class.getName());

	public static Map<String, String> fetchProducts(MoySklad moySklad, boolean onlyRecentMode) throws Exception {
		log.info("Fetching products...");

		List<MoySkladProduct> productList = moySklad.getProducts(onlyRecentMode);

		log.info("Fetched " + productList.size() + " products");

		Map<String, String> productHash = new HashMap<>();

		for (MoySkladProduct product : productList) {
			productHash.put(product.getExternalCode(), product.getMeta().getHref());
		}

		return productHash;
	}

	public static Map<String, String> fetchCounterParties(MoySklad moySklad, boolean onlyRecentMode) throws Exception {
		log.info("Fetching counterparties...");

		List<MoySkladCounterParty> counterPartyList = moySklad.getCounterParties(onlyRecentMode);

		log.info("Fetched " + counterPartyList.size() + " counterparties");

		Map<String, String> counterPartyHash = new HashMap<>();

		for (MoySkladCounterParty counterParty : counterPartyList) {
			String email = counterParty.getEmail();

			if (email != null) {
				counterPartyHash.put(email, counterParty.getMeta().getHref());
			}

			String phone = counterParty.getPhone();

			if (phone != null) {
				counterPartyHash.put(phone, counterParty.getMeta().getHref());
			}
		}

		return counterPartyHash;
	}

	public static HTreeMap<String, String> getProducts(MoySklad moySklad, DB db) throws Exception {
		HTreeMap<String, String> productsMap = db
				.hashMap("products", Serializer.STRING, Serializer.STRING)
				.createOrOpen();

		if (productsMap.size() == 0) {
			try {
				productsMap.putAll(fetchProducts(moySklad, false));
			} catch (Exception e) {
				productsMap.clear();
				throw new Exception("Error loading products map.");
			}

			db.commit();
		} else {
			log.info("Products Map loaded from cache and updating it");

			productsMap.putAll(fetchProducts(moySklad, true));
		}

		return productsMap;
	}

	public static HTreeMap<String, String> getCounterParties(MoySklad moySklad, DB db) throws Exception {
		HTreeMap<String, String> counterPartyMap = db
				.hashMap("counterparty", Serializer.STRING, Serializer.STRING)
				.createOrOpen();

		if (counterPartyMap.size() == 0) {
			try {
				counterPartyMap.putAll(fetchCounterParties(moySklad, false));
			} catch (Exception e) {
				counterPartyMap.clear();
				throw new Exception("Error loading counterParties map.");
			}

			db.commit();
		} else {
			log.info("Counter Party Map loaded from cache and updating it");

			counterPartyMap.putAll(fetchCounterParties(moySklad, true));
		}

		return counterPartyMap;
	}
}
