import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {
    class TwoSum {
        Map<Integer, Integer> map;

        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.compute(number, (key, value) -> value == null ? 1 : value + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (map.get(value - entry.getKey()) != null || (entry.getValue() > 1 && (value - entry.getKey()) == entry.getKey())) {
                    return true;
                }
            }

            return false;
        }
    }
}
