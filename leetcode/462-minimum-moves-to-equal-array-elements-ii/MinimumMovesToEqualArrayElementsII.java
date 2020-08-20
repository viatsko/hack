import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int left = 0;

        int right = nums.length - 1;

        int result = 0;

        while (left <= right) {
            result += nums[right] - nums[left];

            left++;

            right--;
        }

        return result;
    }
}
