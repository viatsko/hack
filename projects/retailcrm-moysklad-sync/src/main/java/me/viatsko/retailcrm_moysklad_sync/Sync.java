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

package me.viatsko.retailcrm_moysklad_sync;

import me.viatsko.retailcrm_moysklad_sync.entity.moysklad.*;
import me.viatsko.retailcrm_moysklad_sync.entity.retailcrm.*;
import me.viatsko.retailcrm_moysklad_sync.moysklad.MoySklad;
import me.viatsko.retailcrm_moysklad_sync.moysklad.MoySkladDictionaries;
import me.viatsko.retailcrm_moysklad_sync.retailcrm.RetailCRM;
import me.viatsko.retailcrm_moysklad_sync.util.DateUtils;
import me.viatsko.retailcrm_moysklad_sync.util.StringUtils;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

class Sync {
    private static final Logger log = Logger.getLogger(Sync.class.getName());

    private Config config = new Config();

    private RetailCRM retailCRM = new RetailCRM(config);

    private MoySklad moySklad = new MoySklad(config);

	private DB db = DBMaker.fileDB("file.db").fileMmapEnable().checksumHeaderBypass().closeOnJvmShutdown().make();

	private HTreeMap<String, String> productsMap;

	private HTreeMap<String, String> counterPartyMap;

	Sync() throws FileNotFoundException {
	}

	private void syncOrders() throws Exception {
		MoySkladMeta storeMeta = new MoySkladMeta.MoySkladMetaBuilder()
				.withHref(config.getMoySkladStoreHref())
				.withType("store")
				.withMediaType("application/json")
				.build();

		MoySkladGenericStore moySkladGenericStore = new MoySkladGenericStore.MoySkladGenericStoreBuilder()
				.withMeta(storeMeta)
				.build();

		List<MoySkladOrder> moySkladOrderList = moySklad.getOrders();

		Map<String, MoySkladOrder> moySkladOrderMap = new HashMap<>();

		for (MoySkladOrder moySkladOrder : moySkladOrderList) {
			// id stores as name in ms
			String name = moySkladOrder.getName();

			if (StringUtils.isNumeric(name)) {
				moySkladOrderMap.put(name, moySkladOrder);
			}
		}

		Map<String, RetailCRMOrder> retailCRMOrdersHistoryEntryMap = new HashMap<>();

		RetailCRMOrdersResponse retailCRMOrdersResponse = retailCRM.getOrders();

		Date date = new Date();

		for (RetailCRMOrder order : retailCRMOrdersResponse.getOrders()) {
			String externalId = order.getExternalId();

			if (externalId == null) {
				continue;
			}

			/*
			 * TODO we need to take 30 minutes from previous day or whatever is in cron
			 * 		as it's an edge-case
			 */
			if (DateUtils.isSameDay(order.getStatusUpdatedAt(), date)) {
				retailCRMOrdersHistoryEntryMap.put(externalId, order);
			}
		}

		int n = retailCRMOrdersHistoryEntryMap.size();

		log.info("Orders to process: " + n);

		if (n > 0) {
			int totalAdded = 0;
			int totalUpdated = 0;

			for (Map.Entry<String, RetailCRMOrder> entry : retailCRMOrdersHistoryEntryMap.entrySet()) {
				String orderId = entry.getKey();

				log.info("Order #" + orderId);

				MoySkladOrder moySkladOrder = null;

				boolean toAdd = !moySkladOrderMap.containsKey(orderId);

				if (toAdd) {
					// add
					log.info("Action: add");

					totalAdded++;
				} else {
					// update
					log.info("Action: update");

					totalUpdated++;

					moySkladOrder = moySkladOrderMap.get(orderId);

					if (moySkladOrder.getApplicable()) {
						log.info("Order is applicable, skipping");

						continue;
					}
				}

				RetailCRMOrder retailCRMOrder = entry.getValue();

				String status = retailCRMOrder.getStatus();

				Boolean asDraft = false;

				if (
						!status.equals("send-to-delivery") &&
						!status.equals("complete") &&
						!status.equals("send-to-assembling") &&
						!status.equals("delivering")
				) {
					asDraft = true;
				}

				List<RetailCRMOrderItem> retailCRMOrderItems = retailCRMOrder.getItems();

				List<String> missingProductList = new ArrayList<>();

				if (retailCRMOrderItems != null) {
					List<MoySkladOrderPosition> positionList = new ArrayList<>();

					for (RetailCRMOrderItem retailCRMOrderItem : retailCRMOrderItems) {
						String productHref = productsMap.get(retailCRMOrderItem.getOffer().getXmlId());

						if (productHref == null) {
							log.warning("Product " + retailCRMOrderItem.getOffer().getName() + " is missing on Moy Sklad");

							missingProductList.add(retailCRMOrderItem.getOffer().getName());

							continue;
						}

						MoySkladMeta productMeta = new MoySkladMeta.MoySkladMetaBuilder()
								.withHref(productHref)
								.withType("product")
								.withMediaType("application/json")
								.build();

						MoySkladOrderPositionAssortment assortment = new MoySkladOrderPositionAssortment.MoySkladOrderPositionAssortmentBuilder()
								.withMeta(productMeta)
								.build();

						MoySkladOrderPosition position = new MoySkladOrderPosition.MoySkladOrderPositionBuilder()
								.withAssortment(assortment)
								.withReserve(0)
								.withPrice(
										retailCRMOrderItem.getInitialPrice() * 100 -
										(
												retailCRMOrderItem.getDiscountTotal() != null ?
														(retailCRMOrderItem.getDiscountTotal() * 100) :
														0
										)
								)
								.withQuantity(retailCRMOrderItem.getQuantity())
								.build();

						positionList.add(position);
					}

					MoySkladMeta organizationMeta = new MoySkladMeta.MoySkladMetaBuilder()
							.withHref(config.getMoySkladOrganizationHref())
							.withType("organization")
							.withMediaType("application/json")
							.build();

					MoySkladGenericOrganization organization = new MoySkladGenericOrganization.MoySkladOrderOrganizationBuilder()
							.withMeta(organizationMeta)
							.build();

					String email = retailCRMOrder.getEmail();

					String counterPartyHref = null;

					if (email != null) {
						counterPartyHref = counterPartyMap.get(email);
					}

					if (retailCRMOrder.getPhone() != null && counterPartyHref == null) {
						counterPartyHref = counterPartyMap.get(retailCRMOrder.getPhone());
					}

					if (toAdd && counterPartyHref == null) {
						log.info("Creating new counter party...");

						RetailCRMOrderCustomerAddress address = retailCRMOrder.getCustomer().getAddress();

						String phone = retailCRMOrder.getPhone();

						MoySkladCreateCounterPartyRequest counterPartyRequest = new MoySkladCreateCounterPartyRequest.MoySkladCreateCounterPartyRequestBuilder()
								.withName(retailCRMOrder.getLastName() + " " + retailCRMOrder.getFirstName() + (retailCRMOrder.getPatronymic() != null ? (" " + retailCRMOrder.getPatronymic()) : ""))
								.withEmail(email == null ? "" : email)
								.withPhone(phone == null ? "" : phone)
								.withActualAddress(address != null ? (address.getIndex() + ", " + address.getText()) : "")
								.build();

						MoySkladCreateCounterPartyResponse counterPartyResponse = moySklad.createCounterParty(counterPartyRequest);

						counterPartyHref = counterPartyResponse.getMeta().getHref();

						if (retailCRMOrder.getEmail() != null) {
							counterPartyMap.put(retailCRMOrder.getEmail(), counterPartyResponse.getMeta().getHref());
						}

						if (retailCRMOrder.getPhone() != null) {
							counterPartyMap.put(retailCRMOrder.getPhone(), counterPartyResponse.getMeta().getHref());
						}

						log.info("Created Counter Party for " + retailCRMOrder.getEmail() + " email address");
					}

					MoySkladMeta agentMeta = new MoySkladMeta.MoySkladMetaBuilder()
							.withHref(counterPartyHref)
							.withType("counterparty")
							.withMediaType("application/json")
							.build();

					MoySkladGenericAgent moySkladGenericAgent = new MoySkladGenericAgent.MoySkladOrderAgentBuilder()
							.withMeta(agentMeta)
							.build();

					String deliveryServiceName = "";

					RetailCRMOrderDelivery delivery = retailCRMOrder.getDelivery();

					if (delivery != null) {
						RetailCRMOrderDeliveryService service = delivery.getService();

						if (service != null) {
							String name = service.getName();

							if (name != null) {
								deliveryServiceName = name;
							}
						}
					}

					StringBuilder orderDescription = new StringBuilder();
					orderDescription.append("[] ");
					orderDescription.append(deliveryServiceName);

					if (missingProductList.size() > 0) {
						orderDescription.append(". Missing: ");

						orderDescription.append(String.join(", ", missingProductList));
					}

					Boolean applicable = true;

					if (missingProductList.size() > 0) {
						applicable = false;
					}

					if (toAdd) {
						MoySkladCreateOrderRequest moySkladCreateOrderRequest =
								new MoySkladCreateOrderRequest.MoySkladCreateOrderRequestBuilder()
										.withName(String.valueOf(orderId))
										.withMoment(retailCRMOrder.getCreatedAt())
										.withDescription(orderDescription.toString())
										.withPositions(positionList)
										.withOrganization(organization)
										.withAgent(moySkladGenericAgent)
										.withApplicable(asDraft ? false : applicable)
										.withVatEnabled(false)
										.build();

						MoySkladCreateOrderResponse moySkladCreateOrderResponse = null;

						try {
							moySkladCreateOrderResponse = moySklad.createOrder(moySkladCreateOrderRequest);

							if (!asDraft && missingProductList.size() == 0) {
								MoySkladMeta customerOrderMeta =
										new MoySkladMeta.MoySkladMetaBuilder()
												.withHref(moySkladCreateOrderResponse.getMeta().getHref())
												.withMetadataHref("https://online.moysklad.ru/api/remap/1.1/entity/customerorder/metadata")
												.withType("customerorder")
												.withMediaType("application/json")
												.build();

								MoySkladDemandCustomerOrder moySkladDemandCustomerOrder =
										new MoySkladDemandCustomerOrder.MoySkladDemandCustomerOrderBuilder()
												.withMeta(customerOrderMeta)
												.build();

								MoySkladCreateDemandRequest moySkladCreateDemandRequest =
										new MoySkladCreateDemandRequest.MoySkladCreateDemandRequestBuilder()
												.withApplicable(false)
												.withVatEnabled(false)
												.withPositions(positionList)
												.withOrganization(organization)
												.withAgent(moySkladGenericAgent)
												.withStore(moySkladGenericStore)
												.withCustomerOrder(moySkladDemandCustomerOrder)
												.build();

								moySklad.createDemand(moySkladCreateDemandRequest);
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					} else {
						MoySkladUpdateOrderRequest moySkladUpdateOrderRequest =
								new MoySkladUpdateOrderRequest.MoySkladUpdateOrderRequestBuilder()
										.withName(String.valueOf(orderId))
										.withMoment(retailCRMOrder.getCreatedAt())
										.withDescription(orderDescription.toString())
										.withPositions(positionList)
										.withOrganization(organization)
										.withAgent(moySkladGenericAgent)
										.withApplicable(asDraft ? false : applicable)
										.withVatEnabled(false)
										.build();



						MoySkladUpdateOrderResponse moySkladUpdateOrderResponse = null;

						try {
							moySkladUpdateOrderResponse = moySklad.updateOrder(moySkladOrder.getId(), moySkladUpdateOrderRequest);;

							if (!asDraft && missingProductList.size() == 0) {
								MoySkladMeta customerOrderMeta =
										new MoySkladMeta.MoySkladMetaBuilder()
												.withHref(moySkladUpdateOrderResponse.getMeta().getHref())
												.withMetadataHref("https://online.moysklad.ru/api/remap/1.1/entity/customerorder/metadata")
												.withType("customerorder")
												.withMediaType("application/json")
												.build();

								MoySkladDemandCustomerOrder moySkladDemandCustomerOrder =
										new MoySkladDemandCustomerOrder.MoySkladDemandCustomerOrderBuilder()
												.withMeta(customerOrderMeta)
												.build();

								MoySkladCreateDemandRequest moySkladCreateDemandRequest =
										new MoySkladCreateDemandRequest.MoySkladCreateDemandRequestBuilder()
												.withApplicable(false)
												.withVatEnabled(false)
												.withPositions(positionList)
												.withOrganization(organization)
												.withAgent(moySkladGenericAgent)
												.withCustomerOrder(moySkladDemandCustomerOrder)
												.withStore(moySkladGenericStore)
												.build();

								moySklad.createDemand(moySkladCreateDemandRequest);
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					}
				}
			}

			log.info("Total added: " + totalAdded);

			log.info("Total updated: " + totalUpdated);
		}
	}

	Sync run() throws Exception {
        productsMap = MoySkladDictionaries.getProducts(moySklad, db);

        counterPartyMap = MoySkladDictionaries.getCounterParties(moySklad, db);

        syncOrders();

        return this;
    }

    void cleanup() {
		db.close();
	}
}
