import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        int result = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((k > 0 && map.get(entry.getKey() + k) != null) || (k == 0 && entry.getValue() >= 2)) {
                result++;
            }
        }

        return result;
    }
}
