package me.viatsko.retailcrm_moysklad_sync.entity.retailcrm;

public class RetailCRMOrderDeliveryAddress {
	public String countryIso;

	public String text;

	public String getCountryIso() {
		return countryIso;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "RetailCRMOrderDeliveryAddress{" +
				"countryIso='" + countryIso + '\'' +
				", text='" + text + '\'' +
				'}';
	}
}
