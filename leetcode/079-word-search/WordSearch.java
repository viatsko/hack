class Solution {
  int[][] dirs = {
      { 0,  1},
      { 0, -1},
      { 1,  0},
      {-1,  0}
  };

  private boolean dfs(char[][] board, String word, int position, int i, int j, boolean[][] visited) {
      if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != word.charAt(position) || visited[i][j]) {
          return false;
      }

      if (position == word.length() - 1) {
          return true;
      }

      visited[i][j] = true;

      for (int k = 0; k < 4; k++) {
          int x = i + dirs[k][0];
          int y = j + dirs[k][1];

          if (dfs(board, word, position + 1, x, y, visited)) {
              return true;
          }
      }

      visited[i][j] = false;

      return false;
  }

  public boolean exist(char[][] board, String word) {
      int N = board.length;
      int M = board[0].length;

      boolean[][] visited = new boolean[N][M];

      char ch = word.charAt(0);

      for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
              if (board[i][j] == ch) {
                  if (dfs(board, word, 0, i, j, visited)) {
                      return true;
                  }
              }
          }
      }

      return false;
  }
}
