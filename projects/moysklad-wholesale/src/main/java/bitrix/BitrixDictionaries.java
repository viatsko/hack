package bitrix;

import java.util.Map;
import java.util.Objects;

public class BitrixDictionaries {
    public static void updateAvailableProductsMap(Bitrix bitrix, Map<String, String> availableProductsMap) throws Exception {
        Map<String, String> tempMap;

        try {
            tempMap = bitrix.getAvailableProductsImages();
        } catch (Exception e) {
            return;
        }

        if (availableProductsMap.size() > 0) {
            tempMap.keySet().removeAll(availableProductsMap.keySet());
        }

        // we need to remove nulls because of ConcurrentHashMap
        // explanation from creator of ConcurrentHashMap:
        // http://cs.oswego.edu/pipermail/concurrency-interest/2006-May/002485.html
        tempMap.values().removeIf(Objects::isNull);

        availableProductsMap.putAll(tempMap);
    }
}
