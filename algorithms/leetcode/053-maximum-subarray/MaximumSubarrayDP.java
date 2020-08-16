class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i] + ((i == 0 || dp[i - 1] < 0) ? 0 : dp[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
