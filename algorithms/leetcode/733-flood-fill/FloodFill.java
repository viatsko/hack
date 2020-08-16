class Solution {
  int[][] grid;
  int nc;
  int oc;

  int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public void fill(int i, int j) {
    if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != oc) {
      return;
    }

    grid[i][j] = nc;

    for (int k = 0; k < 4; k++) {
      fill(i + dirs[k][0], j + dirs[k][1]);
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    grid = image;

    nc = newColor;

    oc = image[sr][sc];

    if (nc != oc) {
      fill(sr, sc);
    }

    return grid;
  }
}
