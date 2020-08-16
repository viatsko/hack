#include <string>

int chessKnight(std::string cell) {
  int i = cell[0] - 'a';
  int j = cell[1] - '1';

  int const moves[8][2] = { {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, -2}, {1, 2} };

  int count = 0;

  for (int k = 0; k < 8; k++) {
    if (
      (i + moves[k][0]) >= 0 &&
      (i + moves[k][0]) < 8 &&
      (j + moves[k][1]) >= 0 &&
      (j + moves[k][1]) < 8
    ) {
      count++;
    }
  }

  return count;
}
