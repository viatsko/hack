package gson.entity.moysklad;

import java.util.List;

public class MoySkladProductsResponse {
    List<MoySkladProduct> rows;

    MoySkladResponseMeta meta;

    public List<MoySkladProduct> getRows() {
        return rows;
    }

    public MoySkladResponseMeta getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return "MoySkladProductsResponse{" +
                "rows=" + rows +
                ", meta=" + meta +
                '}';
    }
}
