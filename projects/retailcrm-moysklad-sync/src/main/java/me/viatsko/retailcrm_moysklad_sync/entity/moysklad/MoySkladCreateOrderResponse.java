package me.viatsko.retailcrm_moysklad_sync.entity.moysklad;

public class MoySkladCreateOrderResponse {
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
		return "MoySkladCreateOrderResponse{" +
				"id='" + id + '\'' +
				", meta=" + meta +
				'}';
	}
}
