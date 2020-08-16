package gson.entity.retailcrm;

public class RetailCRMOrderItem {
    Double quantity;

    Double initialPrice;

    RetailCRMOrderItemOffer offer;

    public Double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "RetailCRMOrderItem{" +
                "quantity=" + quantity +
                ", initialPrice=" + initialPrice +
                ", offer=" + offer +
                '}';
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public RetailCRMOrderItemOffer getOffer() {
        return offer;
    }

    public static final class RetailCRMOrderItemBuilder {
        Double quantity;
        Double initialPrice;
        RetailCRMOrderItemOffer offer;

        public RetailCRMOrderItemBuilder() {
        }

        public static RetailCRMOrderItemBuilder aRetailCRMOrderItem() {
            return new RetailCRMOrderItemBuilder();
        }

        public RetailCRMOrderItemBuilder withQuantity(Double quantity) {
            this.quantity = quantity;
            return this;
        }

        public RetailCRMOrderItemBuilder withInitialPrice(Double initialPrice) {
            this.initialPrice = initialPrice;
            return this;
        }

        public RetailCRMOrderItemBuilder withOffer(RetailCRMOrderItemOffer offer) {
            this.offer = offer;
            return this;
        }

        public RetailCRMOrderItem build() {
            RetailCRMOrderItem retailCRMOrderItem = new RetailCRMOrderItem();
            retailCRMOrderItem.offer = this.offer;
            retailCRMOrderItem.quantity = this.quantity;
            retailCRMOrderItem.initialPrice = this.initialPrice;
            return retailCRMOrderItem;
        }
    }
}
