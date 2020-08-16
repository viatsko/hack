class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + ((i == 0 || nums[i - 1] < 0) ? 0 : nums[i - 1]);
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
