class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        
        if (N == 0) {
            return 0;
        }
        
        if (N == 1) {
            return nums[0];
        }
        
        int[] dp = new int[N + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + (i < N ? nums[i] : 0));
        }
        
        return dp[N];
    }
}
