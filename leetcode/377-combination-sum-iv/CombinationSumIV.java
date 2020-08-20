class Solution {
    public int helper(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }

        int answer = 0;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target >= nums[i]) {
                answer += helper(nums, target - nums[i], dp);
            }
        }
        
        dp[target] = answer;
        
        return answer;
    }
    
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        Arrays.sort(nums);
        dp[0] = 1;
        return helper(nums, target, dp);
    }
}
