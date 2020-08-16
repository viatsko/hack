package gson.entity.api.endpoints;

import gson.entity.moysklad.MoySkladProduct;

import java.util.List;

public class GetProductsByPriceTypeResponse {
    List<MoySkladProduct> products;

    @Override
    public String toString() {
        return "GetProductsByPriceTypeResponse{" +
                "products=" + products +
                '}';
    }

    public static final class GetProductsByPriceTypeResponseBuilder {
        List<MoySkladProduct> products;

        public GetProductsByPriceTypeResponseBuilder() {
        }

        public static GetProductsByPriceTypeResponseBuilder aGetProductsByPriceTypeResponse() {
            return new GetProductsByPriceTypeResponseBuilder();
        }

        public GetProductsByPriceTypeResponseBuilder withProducts(List<MoySkladProduct> products) {
            this.products = products;
            return this;
        }

        public GetProductsByPriceTypeResponse build() {
            GetProductsByPriceTypeResponse getProductsByPriceTypeResponse = new GetProductsByPriceTypeResponse();
            getProductsByPriceTypeResponse.products = this.products;
            return getProductsByPriceTypeResponse;
        }
    }
}
