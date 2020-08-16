#include <cmath>
#include <vector>

class Solution {
public:
  int maximalSquare(
    std::vector<std::vector<char>>& matrix,
    std::vector<std::vector<char>>::size_type i,
    std::vector<char>::size_type j,
    std::vector<std::vector<int>>& dp
  ) {
    if (i == matrix.size() || j == matrix[0].size()) {
      return 0;
    }

    if (dp[i][j] == 0) {
      if (matrix[i][j] == '0') {
        return 0;
      }

      dp[i][j] = 1 + std::min(
        maximalSquare(matrix, i + 1, j, dp),
        std::min(
          maximalSquare(matrix, i, j + 1, dp),
          maximalSquare(matrix, i + 1, j + 1, dp)
        )
      );
    }

    return dp[i][j];
  }

  int maximalSquare(std::vector<std::vector<char>>& matrix) {
    if (matrix.size() == 0 || matrix[0].size() == 0) {
      return false;
    }

    std::vector<std::vector<int>> dp(matrix.size(), std::vector<int>(matrix[0].size(), 0));

    int result = 0;

    for (std::vector<std::vector<char>>::size_type i = 0; i < matrix.size(); i++) {
      for (std::vector<char>::size_type j = 0; j < matrix[0].size(); j++) {
        result = std::max(result, maximalSquare(matrix, i, j, dp));
      }
    }

    return result * result;
  }
};
