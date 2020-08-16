import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int current = nums[i];
            int countInRange = 0;

            while(i < (n - 1) && (nums[i] + 1) == nums[i + 1]) {
                countInRange++;
                i++;
            }

            if (countInRange > 0) {
                result.add(String.valueOf(current) + "->" + String.valueOf(current + countInRange));
            } else {
                result.add(String.valueOf(current));
            }
        }

        return result;
    }
}
