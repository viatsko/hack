class Solution {
    private int rob(int[] nums, int left, int right) {
        int[] dp = new int[right + 1];
        
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        
        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + (i < right ? nums[i] : 0));
        }
        
        return dp[right];
    }

    public int rob(int[] nums) {
        int N = nums.length;
        
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return nums[0];
        } else if (N == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }
}
