class Solution {
    private int catalan(int[] dp, int n) {
        if (n <= 1) {
            return 1;
        }
        
        if (dp[n] > 0) {
            return dp[n];
        }
        
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            res += catalan(dp, i) * catalan(dp, n - i - 1);
        }
        
        dp[n] = res;
        
        return res;
    }
    
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        return catalan(dp, n);
    }
}
