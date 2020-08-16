import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1)) {
                result = Math.max(result, entry.getValue() + map.get(entry.getKey() + 1));
            }
        }

        return result;
    }
}
