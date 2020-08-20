import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        /*
         * HashSet insertion is O(1)
         * vs possible TreeSet O(logN),
         * so TreeSet might have pushed it to NlogN
         * vs max allowed O(N)
         */
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(++current)) {
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
