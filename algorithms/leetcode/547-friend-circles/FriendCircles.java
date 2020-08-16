class Solution {
  public int findCircleNum(int[][] grid) {
    int m = grid.length;
    if (m == 0) { return 0; }
    int n = grid[0].length;
    if (n == 0) { return 0; }

    int[] id = new int[m];
    Arrays.fill(id, -1);

    int count = m;

    for (int i = 0; i < m; i++) {
      id[i] = i;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          int r1 = find(i, id);
          int r2 = find(j, id);

          if (r1 != r2) {
            id[r1] = r2;
            count--;
          }
        }
      }
    }

    return count;
  }

  private int find(int i, int[] id) {
    while (id[i] != i) {
      i = id[i];
    }

    return i;
  }
}
