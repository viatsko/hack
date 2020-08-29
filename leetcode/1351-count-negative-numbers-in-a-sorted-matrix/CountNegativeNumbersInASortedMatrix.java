class Solution {
  public int countNegatives(int[][] grid) {
    int i = 0;
    int j = grid[0].length - 1;
    int res = 0;
    while (i < grid.length && j >= 0) {
      while (i < grid.length && grid[i][j] >= 0) {
        i++;
      }

      res += (grid.length - i);

      j--;
    }
    return res;
  }
}
