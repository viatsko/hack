package gson.entity.api.endpoints;

import java.util.List;

public class GetPriceTypesResponse {
    List<String> priceTypes;

    public static final class GetPriceTypesResponseBuilder {
        List<String> priceTypes;

        public GetPriceTypesResponseBuilder() {
        }

        public static GetPriceTypesResponseBuilder aGetPriceTypesResponse() {
            return new GetPriceTypesResponseBuilder();
        }

        public GetPriceTypesResponseBuilder withPriceTypes(List<String> priceTypes) {
            this.priceTypes = priceTypes;
            return this;
        }

        public GetPriceTypesResponse build() {
            GetPriceTypesResponse getPriceTypesResponse = new GetPriceTypesResponse();
            getPriceTypesResponse.priceTypes = this.priceTypes;
            return getPriceTypesResponse;
        }
    }
}
