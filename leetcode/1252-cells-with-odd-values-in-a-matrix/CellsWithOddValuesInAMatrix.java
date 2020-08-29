class Solution {
  public int oddCells(int n, int m, int[][] indices) {
    boolean[][] mat = new boolean[n][m];

    for (boolean[] row : mat) {
      Arrays.fill(row, true);
    }

    for (int[] indice : indices) {
      for (int k = 0; k < m; k++) {
        mat[indice[0]][k] ^= true;
      }
      for (int k = 0; k < n; k++) {
        mat[k][indice[1]] ^= true;
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!mat[i][j]) {
          result++;
        }
      }
    }
    return result;
  }
}
