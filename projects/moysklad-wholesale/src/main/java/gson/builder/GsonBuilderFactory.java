package gson.builder;

import com.google.gson.GsonBuilder;
import util.DateUtils;

import java.util.Objects;

public class GsonBuilderFactory {
    public static GsonBuilder getGsonBuilder(String type) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        if (Objects.equals(type, "mysql")) {
            gsonBuilder.setDateFormat(DateUtils.MYSQL_DATE_FORMAT);
        }

        return gsonBuilder;
    }
}
