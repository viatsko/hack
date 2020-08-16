class Solution {
    public int numDecodings(String s) {
        int N = s.length();
        
        int[] dp = new int[N + 1];
        
        dp[0] = 1;
        
        for (int i = 1; i <= N; i++) {
            int single = s.charAt(i - 1) - '0';
            int dbl = i >= 2 ? (s.charAt(i - 2) - '0') * 10 + single : 0;
            
            if (single >= 1) {
                dp[i] += dp[i - 1];
            }
            
            if (dbl >= 10 && dbl <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[N];
    }
}
