#include <vector>

class Solution {
public:
    bool isToeplitzMatrix(std::vector<std::vector<int>>& matrix) {
      for (std::vector<std::vector<int>>::size_type i = 0; i < matrix.size() - 1; i++) {
        for (std::vector<int>::size_type j = 0; j < matrix[0].size() - 1; j++) {
          if (matrix[i][j] != matrix[i + 1][j + 1]) {
            return false;
          }
        }
      }

      return true;
    }
};
