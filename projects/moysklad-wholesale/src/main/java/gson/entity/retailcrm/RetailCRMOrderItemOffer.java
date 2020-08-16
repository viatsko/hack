package gson.entity.retailcrm;

public class RetailCRMOrderItemOffer {
    Integer id;

    String externalId;

    String xmlId;

    public Integer getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getXmlId() {
        return xmlId;
    }

    @Override
    public String toString() {
        return "RetailCRMOrderItemOffer{" +
                "id=" + id +
                ", externalId='" + externalId + '\'' +
                ", xmlId='" + xmlId + '\'' +
                '}';
    }

    public static final class RetailCRMOrderItemOfferBuilder {
        Integer id;
        String externalId;
        String xmlId;

        public RetailCRMOrderItemOfferBuilder() {
        }

        public static RetailCRMOrderItemOfferBuilder aRetailCRMOrderItemOffer() {
            return new RetailCRMOrderItemOfferBuilder();
        }

        public RetailCRMOrderItemOfferBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public RetailCRMOrderItemOfferBuilder withExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public RetailCRMOrderItemOfferBuilder withXmlId(String xmlId) {
            this.xmlId = xmlId;
            return this;
        }

        public RetailCRMOrderItemOffer build() {
            RetailCRMOrderItemOffer retailCRMOrderItemOffer = new RetailCRMOrderItemOffer();
            retailCRMOrderItemOffer.externalId = this.externalId;
            retailCRMOrderItemOffer.id = this.id;
            retailCRMOrderItemOffer.xmlId = this.xmlId;
            return retailCRMOrderItemOffer;
        }
    }
}
