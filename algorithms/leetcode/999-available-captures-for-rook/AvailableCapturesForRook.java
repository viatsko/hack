class Solution {
    private int[][] directions = {
        {  0,  1 },
        {  1,  0 },
        {  0, -1 },
        { -1,  0 }
    };
    
    private int scanDirection(char[][] board, int start_i, int start_j, int[] direction) {
        int i = start_i + direction[0];
        int j = start_j + direction[1];
        while (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (board[i][j] == 'p') {
                return 1;
            } else if (board[i][j] != '.') {
                return 0;
            }
            i += direction[0];
            j += direction[1];
        }
        return 0;
    }
    
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    int result = 0;
                    for (int[] direction : directions) {
                        result += scanDirection(board, i, j, direction);
                    }
                    return result;
                }
            }
        }
        
        return 0;
    }
}
