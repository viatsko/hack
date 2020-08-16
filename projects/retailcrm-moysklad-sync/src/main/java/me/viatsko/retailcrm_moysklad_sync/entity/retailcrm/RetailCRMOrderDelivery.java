package me.viatsko.retailcrm_moysklad_sync.entity.retailcrm;

public class RetailCRMOrderDelivery {
	public String code;

	public RetailCRMOrderDeliveryService service;

	public Double cost;

	public Double netCost;

	public RetailCRMOrderDeliveryAddress address;

	public String getCode() {
		return code;
	}

	public RetailCRMOrderDeliveryService getService() {
		return service;
	}

	public Double getCost() {
		return cost;
	}

	public Double getNetCost() {
		return netCost;
	}

	public RetailCRMOrderDeliveryAddress getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "RetailCRMOrderDelivery{" +
				"code='" + code + '\'' +
				", service=" + service +
				", cost=" + cost +
				", netCost=" + netCost +
				", address=" + address +
				'}';
	}
}
