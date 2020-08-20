class Solution {
  public int minCostClimbingStairs(int[] dp) {
    int N = dp.length;

    for (int i = 2; i < N; i++) {
      dp[i] += Math.min(dp[i - 2], dp[i - 1]);
    }

    return Math.min(dp[N - 2], dp[N - 1]);
  }
}
