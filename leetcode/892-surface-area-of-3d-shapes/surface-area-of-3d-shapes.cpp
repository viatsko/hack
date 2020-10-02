class Solution {
public:
  int surfaceArea(vector<vector<int>> &grid) {
    int result = 0;

    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid[0].size(); j++) {
        if (grid[i][j])
          result += grid[i][j] * 4 + 2;
        if (i > 0)
          result -= min(grid[i][j], grid[i - 1][j]) * 2;
        if (j > 0)
          result -= min(grid[i][j], grid[i][j - 1]) * 2;
      }
    }

    return result;
  }
};
