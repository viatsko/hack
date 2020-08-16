class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        
        if (N == 0) {
            return false;
        }
        
        boolean[] dp = new boolean[N + 1];
        dp[0] = true;
        
        Set<String> wordSet = new HashSet<>(wordDict);
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[N];
    }
}
