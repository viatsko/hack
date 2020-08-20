import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int duplicated = -1;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                duplicated = num;
            }

            set.add(num);
        }

        int missing = -1;

        for (int i = 1 ; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
            }
        }

        return new int[]{duplicated, missing};
    }
}
