package gson.entity.moysklad;

public class MoySkladProductSalePrice {
    Double value;

    String priceType;

    public Double getValue() {
        return value;
    }

    public String getPriceType() {
        return priceType;
    }

    @Override
    public String toString() {
        return "MoySkladProductSalePrice{" +
                "value=" + value +
                ", priceType='" + priceType + '\'' +
                '}';
    }
}
