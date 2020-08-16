package gson.entity.moysklad;

import java.util.List;

public class MoySkladProduct {
    String name;

    String pathName;

    String code;

    String externalCode;

    String imageUrl;

    MoySkladMeta meta;

    List<MoySkladProductSalePrice> salePrices;

    public String getName() {
        return name;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getCode() {
        return code;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setMeta(MoySkladMeta meta) {
        this.meta = meta;
    }

    public MoySkladMeta getMeta() {
        return meta;
    }

    public void setSalePrices(List<MoySkladProductSalePrice> salePrices) {
        this.salePrices = salePrices;
    }

    public List<MoySkladProductSalePrice> getSalePrices() {
        return salePrices;
    }

    @Override
    public String toString() {
        return "MoySkladProduct{" +
                "name='" + name + '\'' +
                ", pathName='" + pathName + '\'' +
                ", code='" + code + '\'' +
                ", externalCode='" + externalCode + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", meta=" + meta +
                ", salePrices=" + salePrices +
                '}';
    }
}
