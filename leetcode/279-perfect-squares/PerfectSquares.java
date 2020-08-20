class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }
    
    private int helper(int[] memo, int n) {
        if (n <= 3) {
            return n;
        }
        
        if (memo[n] > 0) {
            return memo[n];
        }
        
        int min = n;
        
        for (int i = 1; i <= n; i++) {
            int powered = i * i;
            
            if (powered > n)
                break;
            
            min = Math.min(min, 1 + helper(memo, n - powered));
        }
        
        memo[n] = min;
        
        return min;
    }
}
