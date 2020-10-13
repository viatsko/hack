class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] memo = new int[matrix.length][matrix[0].length];

        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(matrix, i, j, memo);
                result = Math.max(result, len);
            }
        }

        return result;
    }

    private int[][] dirs = new int[][]{
        {-1, 0},
        {0, -1},
        {1, 0},
        {0, 1}
    };
    public int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j];

        int result = 1;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
                continue;

            result = Math.max(result, 1 + dfs(matrix, x, y, memo));
        }

        memo[i][j] = result;
        return result;
    }
}
