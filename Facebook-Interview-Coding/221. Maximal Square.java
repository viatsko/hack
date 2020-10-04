221. Maximal Square

Given a 2D binary matrix filled with 0s and 1s, find the largest square containing only 1s and return its area.
For example, given the following matrix:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

Solution: DP 
dp[i][j] = Math.min(Math.min(dp[i][j-1] , dp[i-1][j-1]), dp[i-1][j]) + 1;

//mine
public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0)     return 0;
    int m = matrix.length, n = matrix[0].length, max = 0;
    int[] prev = new int[n + 1];
    for (int i = 0; i < m; i++) {
        int[] cur = new int[n + 1];
        for (int j = 0; j < n; j++) 
            if (matrix[i][j] == '1') {
                cur[j + 1] = Math.min(cur[j], Math.min(prev[j + 1], prev[j])) + 1;
                max = Math.max(max, cur[j + 1]);
            }
        prev = cur;
    }
    return max * max;
}
        
// https://leetcode.com/articles/maximal-square/
public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0)     return 0;
    int m = matrix.length, n = matrix[0].length;
    int max = 0;
    int[] dp = new int[n + 1];
    for (int i = 0; i < m; i++) {
        int prev = 0;
        for (int j = 0; j < n; j++) {
            int tmp = dp[j + 1];
            if (matrix[i][j] == '1') {
                dp[j + 1] = Math.min(dp[j], Math.min(dp[j + 1], prev)) + 1;
                max = Math.max(max, dp[j + 1]);
            } else      dp[j + 1] = 0; // important!!
            prev = tmp;
        }
    }
    return max * max;
}