#include <vector>

class Solution {
public:
  int maxIncreaseKeepingSkyline(std::vector<std::vector<int>>& grid) {
    int len = grid.size();
    std::vector<int> rows(len, INT_MIN);
    std::vector<int> cols(len, INT_MIN);
    for (std::vector<std::vector<int>>::size_type i = 0; i < len; i++) {
      for (std::vector<int>::size_type j = 0; j < len; j++) {
        rows[i] = std::max(rows[i], grid[i][j]);
        cols[j] = std::max(cols[j], grid[i][j]);
      }
    }

    int result = 0;
    for (std::vector<std::vector<int>>::size_type i = 0; i < len; i++) {
      for (std::vector<int>::size_type j = 0; j < len; j++) {
        result += std::min(rows[i], cols[j]) - grid[i][j];
      }
    }
    return result;
  }
};
