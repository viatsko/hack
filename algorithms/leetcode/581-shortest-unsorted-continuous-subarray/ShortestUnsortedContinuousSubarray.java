public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;

        int l = 0;

        int r = nums.length - 1;

        int begin = 0;

        int end = -1;

        while (r >= 0) {
            max = Math.max(max, nums[l]);
            if (nums[l] != max) {
                end = l;
            }

            min = Math.min(min, nums[r]);
            if (nums[r] != min) {
                begin = r;
            }

            l++;
            r--;
        }

        return end - begin + 1;
    }
}
