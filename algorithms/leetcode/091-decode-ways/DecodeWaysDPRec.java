class Solution {
  public int solve (String s, int[] dp, int position) {
    int n = s.length();

    if (position > n) {
      return 0;
    }

    if (position == n) {
      return 1;
    }

    if (dp[position] == -1) {
      int result = 0;

      if ((position < n - 1) && (s.charAt(position) == '1' ||
           s.charAt(position) == '2' && s.charAt(position + 1) >= '0' && s.charAt(position + 1) <= '6')) {
        result += solve(s, dp, position + 2);
      }

      if (s.charAt(position) != '0') {
        result += solve(s, dp, position + 1);
      }

      dp[position] = result;
    }

    return dp[position];
  }

  public int numDecodings(String s) {
    int dp[] = new int[s.length()];

    for (int i = 0; i < dp.length; i++) {
      dp[i] = -1;
    }

    return solve(s, dp, 0);
  }
}
