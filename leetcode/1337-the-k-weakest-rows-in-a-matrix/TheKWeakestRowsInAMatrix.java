class Solution {
  public int[] kWeakestRows(int[][] mat, int k) {
    Integer[][] power = new Integer[mat.length][2];

    for (int i = 0; i < mat.length; i++) {
      int currentPower = 0;
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 1) {
          currentPower++;
        } else {
          break;
        }
      }
      power[i] = new Integer[] {i, currentPower};
    }

    Arrays.sort(power, (a, b) -> (a[1] == b[1]) ? (a[0] - b[0]) : (a[1] - b[1]));

    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = power[i][0];
    }
    return res;
  }
}
