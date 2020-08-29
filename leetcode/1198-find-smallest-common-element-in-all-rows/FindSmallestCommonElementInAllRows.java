class Solution {
  public int smallestCommonElement(int[][] mat) {
    int[] occ = new int[10001];

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        occ[mat[i][j]]++;
        if (occ[mat[i][j]] == mat.length) {
          return mat[i][j];
        }
      }
    }

    return -1;
  }
}
