package me.viatsko.retailcrm_moysklad_sync.entity.retailcrm;

public class RetailCRMOrderDeliveryService {
	public String name;

	public String code;

	public Boolean active;

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public Boolean getActive() {
		return active;
	}

	@Override
	public String toString() {
		return "RetailCRMOrderDeliveryService{" +
				"name='" + name + '\'' +
				", code='" + code + '\'' +
				", active=" + active +
				'}';
	}
}
