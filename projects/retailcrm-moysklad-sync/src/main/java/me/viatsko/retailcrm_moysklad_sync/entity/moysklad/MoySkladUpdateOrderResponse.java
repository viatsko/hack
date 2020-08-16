package me.viatsko.retailcrm_moysklad_sync.entity.moysklad;

public class MoySkladUpdateOrderResponse {
	public String id;

	public MoySkladMeta meta;

	public String getId() {
		return id;
	}

	public MoySkladMeta getMeta() {
		return meta;
	}

	@Override
	public String toString() {
		return "MoySkladUpdateOrderResponse{" +
				"id='" + id + '\'' +
				", meta=" + meta +
				'}';
	}
}
