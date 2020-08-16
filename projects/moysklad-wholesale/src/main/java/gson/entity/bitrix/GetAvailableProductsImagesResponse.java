package gson.entity.bitrix;

import java.util.Map;

public class GetAvailableProductsImagesResponse {
    Map<String, String> products;

    public Map<String, String> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "GetAvailableProductsImagesResponse{" +
                "products=" + products +
                '}';
    }
}
