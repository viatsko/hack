package gson.entity.moysklad;

public class MoySkladResponseMeta {
    public String href;

    public String metadataHref;

    public String type;

    public String mediaType;

    public Integer size;

    public Integer limit;

    public Integer offset;

    public String nextHref;

    public String getHref() {
        return href;
    }

    public String getMetadataHref() {
        return metadataHref;
    }

    public String getType() {
        return type;
    }

    public String getMediaType() {
        return mediaType;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public String getNextHref() {
        return nextHref;
    }

    @Override
    public String toString() {
        return "MoySkladResponseMeta{" +
                "href='" + href + '\'' +
                ", metadataHref='" + metadataHref + '\'' +
                ", type='" + type + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", size=" + size +
                ", limit=" + limit +
                ", offset=" + offset +
                ", nextHref='" + nextHref + '\'' +
                '}';
    }
}
