#include <vector>

bool sudoku(std::vector<std::vector<int>> grid) {
  int cols[9] = { 0 };
  int rows[9] = { 0 };
  int groups[3][3] = { 0 };

  for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
      int n = grid[i][j];

      if (rows[i] & (1 << n)) {
        return false;
      } else {
        rows[i] |= (1 << n);
      }

      if (cols[j] & (1 << n)) {
        return false;
      } else {
        cols[j] |= (1 << n);
      }

      int gi = i / 3;
      int gj = j / 3;

      if (groups[gi][gj] & (1 << n)) {
        return false;
      } else {
        groups[gi][gj] |= (1 << n);
      }
    }
  }
}
