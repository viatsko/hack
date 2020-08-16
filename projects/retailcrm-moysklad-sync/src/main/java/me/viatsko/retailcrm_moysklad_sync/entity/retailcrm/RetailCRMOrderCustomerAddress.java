package me.viatsko.retailcrm_moysklad_sync.entity.retailcrm;

public class RetailCRMOrderCustomerAddress {
	public String index;

	public String countryIso;

	public String text;

	public String getIndex() {
		return index;
	}

	public String getCountryIso() {
		return countryIso;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "RetailCRMOrderCustomerAddress{" +
				"index='" + index + '\'' +
				", countryIso='" + countryIso + '\'' +
				", text='" + text + '\'' +
				'}';
	}
}
