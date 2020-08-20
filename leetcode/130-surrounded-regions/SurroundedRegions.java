class Solution {
  private void replace(char[][] board, int m, int n, char from, char to) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == from) {
          board[i][j] = to;
        }
      }
    }
  }

  private void flipCorners(char[][] board, int m, int n) {
    int lastRow = m - 1;
    int lastCol = n - 1;

    for (int i = 0; i < m; i++) {
      if (board[i][0] == '.') {
        flip(board, m, n, i, 0);
      }
      if (board[i][lastCol] == '.') {
        flip(board, m, n, i, lastCol);
      }
    }

    for (int j = 1; j < n - 1; j++) {
      if (board[0][j] == '.') {
        flip(board, m, n, 0, j);
      }
      if (board[lastRow][j] == '.') {
        flip(board, m, n, lastRow, j);
      }
    }
  }

  private void flip(char[][] board, int m, int n, int i, int j) {
    if (i < 0 || j < 0 || i == m || j == n || board[i][j] != '.') {
      return;
    }

    if (board[i][j] == '.') {
      board[i][j] = 'O';
    }

    flip(board, m, n, i + 1, j);
    flip(board, m, n, i - 1, j);
    flip(board, m, n, i, j + 1);
    flip(board, m, n, i, j - 1);
  }

  public void solve(char[][] board) {
    int m = board.length;

    if (m <= 2) { // there's no way to have something in the middle realistically
      return;
    }

    int n = board[0].length;

    if (n <= 2) { // there's no way to have something in the middle realistically
      return;
    }

    replace(board, m, n, 'O', '.');

    flipCorners(board, m, n);

    replace(board, m, n, '.', 'X');
  }
}
