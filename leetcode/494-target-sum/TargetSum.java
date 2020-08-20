class Solution {
  public int findTargetSumWays(int[] nums, int S) {
    if (nums.length == 0) {
      return 0;
    }

    int maxS = 0;

    for (int num : nums) maxS += num;

    if (S > maxS) {
      return 0;
    }

    int[][] dp = new int[nums.length + 1][2 * maxS + 1];

    dp[0][maxS] = 1;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (j - nums[i - 1] >= 0) {
          dp[i][j] += dp[i - 1][j - nums[i - 1]];
        }
        if (j + nums[i - 1] < dp[0].length) {
          dp[i][j] += dp[i - 1][j + nums[i - 1]];
        }
      }
    }

    return dp[nums.length][maxS + S];
  }
}
