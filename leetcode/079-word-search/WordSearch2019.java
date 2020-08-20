// O(N * M * 4 ^ k), k = word length
class Solution {
    int[][] directions = new int[][] {
        {  0,  1 },
        {  1,  0 },
        {  0, -1 },
        { -1,  0 }
    };
    
    public boolean seek(char[][] board, boolean[][] visited, String word, int pos, int i, int j) {
        //System.out.printf("pos = %d i = %d j = %d\n", pos, i, j);
        if (i < 0 || i >= board.length) {
            return false;
        }
        
        if (j < 0 || j >= board[0].length) {
            return false;
        }
        
        if (visited[i][j]) {
            return false;
        }
        
        if (word.charAt(pos) != board[i][j]) {
            return false;
        }
        
        if (pos == word.length() - 1) {
            return true;
        }
        
        visited[i][j] = true;
        
        for (int[] direction : directions) {
            if (seek(board, visited, word, pos + 1, i + direction[0], j + direction[1])) {
                return true;
            }
        }
        
        visited[i][j] = false;
        
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (seek(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
