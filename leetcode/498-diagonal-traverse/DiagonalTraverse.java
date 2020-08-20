class Solution {
  public int[] findDiagonalOrder(int[][] matrix) {
    int m = matrix.length;

    if (m == 0) {
      return new int[0];
    }

    int n = matrix[0].length;

    if (n == 0) {
      return new int[0];
    }

    int[] result = new int[m * n];

    int dirR = -1;
    int dirC = 1;

    int i = 0;
    int j = 0;

    int k = 0;

    while (k < m * n) {
      result[k++] = matrix[i][j];

      i += dirR;
      j += dirC;

      if (i < 0 || j == matrix[0].length) {
        dirR = 1;
        dirC = -1;
      } else if (j < 0 || i == matrix.length) {
        dirR = -1;
        dirC = 1;
      }

      if (i == matrix.length) {
        i -= 1;
        j += 2;
      }

      if (j == matrix[0].length) {
        j -= 1;
        i += 2;
      }

      if (i < 0) {
        i = 0;
      }

      if (j < 0) {
        j = 0;
      }
    }

    return result;
  }
}
