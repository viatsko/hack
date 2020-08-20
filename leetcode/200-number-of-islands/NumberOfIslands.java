class Solution {
    int[][] dirs = new int[][] {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    public int numIslands(char[][] grid) {
        int answer = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    visitIsland(grid, i, j);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void visitIsland(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        for (int k = 0; k < 4; k++) {
            int[] next = new int[]{i + dirs[k][0], j + dirs[k][1]};
            
            if (next[0] >= 0 && next[0] < grid.length && next[1] >= 0 && next[1] < grid[0].length && grid[next[0]][next[1]] == '1') {
                visitIsland(grid, next[0], next[1]);
            }
        }
    }
}
