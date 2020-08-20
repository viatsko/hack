#include <vector>

class Solution {
public:
  int maximalSquare(std::vector<std::vector<char>>& matrix) {
    if (matrix.size() == 0 || matrix[0].size() == 0) {
      return 0;
    }

    std::vector<std::vector<int>> dp(matrix.size(), std::vector<int>(matrix[0].size(), 0));

    int result = 0;

    for (std::vector<std::vector<int>>::size_type i = 0; i < matrix.size(); i++) {
      for (std::vector<int>::size_type j = 0; j < matrix[0].size(); j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
        } else if (matrix[i][j] == '1') {
          dp[i][j] = 1 + std::min(
            dp[i - 1][j],
            std::min(
              dp[i][j - 1],
              dp[i - 1][j - 1]
            )
          );
        }

        result = std::max(result, dp[i][j]);
      }
    }

    return result * result;
  }
};
