import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;

        Map<Integer, String> ranksMap = new HashMap<>();

        Integer[] ranks = IntStream.of(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(ranks, (a, b) -> (b - a));

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ranksMap.put(ranks[i], "Gold Medal");
            } else if (i == 1) {
                ranksMap.put(ranks[i], "Silver Medal");
            } else if (i == 2) {
                ranksMap.put(ranks[i], "Bronze Medal");
            } else {
                ranksMap.put(ranks[i], Integer.toString(i + 1));
            }
        }

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = ranksMap.get(nums[i]);
        }

        return result;
    }
}
