#include <set>
#include <vector>

int differentSquares(std::vector<std::vector<int>> matrix) {
  std::set<int> unique;

  for (std::vector<std::vector<int>>::size_type i = 0; i < matrix.size() - 1; i++) {
    for (std::vector<int>::size_type j = 0; j < matrix[0].size() - 1; j++) {
      int num =
        matrix[i][j] * 1000 +
        matrix[i][j + 1] * 100 +
        matrix[i + 1][j] * 10 +
        matrix[i + 1][j + 1];

      unique.insert(num);
    }
  }

  return unique.size();
}
