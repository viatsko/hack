class Solution {
    int[][] directions = {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 }
    };
    
    private int walk(int[][] grid, int i, int j, int zeroes) {
        int result = 0;
        
        for (int[] direction : directions) {
            int x = direction[0];
            int y = direction[1];
            
            int new_i = i + x;
            int new_j = j + y;
            
            if (
                new_i >= 0 && new_i < grid.length &&
                new_j >= 0 && new_j < grid[0].length
            ) {
                int newValue = grid[new_i][new_j];
                if (newValue == 0) {
                    grid[new_i][new_j] = 1;
                    result += walk(grid, new_i, new_j, zeroes - 1);
                    grid[new_i][new_j] = 0;
                } else if (newValue == 2 && zeroes == 0) {
                    result = 1;
                }
            }
        }
        
        return result;
    }
    
    public int uniquePathsIII(int[][] grid) {
        int start_i = -1, start_j = -1, zeroes = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int currentValue = grid[i][j];
                if (currentValue == 1) {
                    start_i = i;
                    start_j = j;
                } else if (currentValue == 0) {
                    zeroes++;
                }
            }
        }
        
        return walk(grid, start_i, start_j, zeroes);
    }
}
