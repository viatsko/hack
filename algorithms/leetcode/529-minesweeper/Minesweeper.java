class Solution {
  int[][] dirs = new int[][]{
      {-1, -1},
      {-1,  0},
      {-1,  1},
      { 0,  1},
      { 0, -1},
      { 1,  1},
      { 1,  0},
      { 1, -1}
  };

  private void dfs(char[][] board, int i, int j) {
      int count = 0;

      for (int[] dir : dirs) {
          int ni = i + dir[0];
          int nj = j + dir[1];

          if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length && board[ni][nj] == 'M') {
              count++;
          }
      }

      if (count > 0) {
          board[i][j] = (char) ('0' + count);
      } else {
          board[i][j] = 'B';

          for (int[] dir : dirs) {
              int ni = i + dir[0];
              int nj = j + dir[1];

              if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length && board[ni][nj] == 'E') {
                  board[ni][nj] = 'B';
                  dfs(board, ni, nj);
              }
          }
      }
  }

  public char[][] updateBoard(char[][] board, int[] click) {
      int i = click[0];
      int j = click[1];

      if (board[i][j] == 'M') {
          board[i][j] = 'X';
      } else {
          dfs(board, i, j);
      }

      return board;
  }
}
