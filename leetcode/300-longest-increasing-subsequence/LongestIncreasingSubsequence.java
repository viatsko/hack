class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        
        if (N == 0) {
            return 0;
        }
        
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        int answer = 1;
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    answer = Math.max(answer, dp[i]);
                }
            }
        }
        
        return answer;
    }
}
