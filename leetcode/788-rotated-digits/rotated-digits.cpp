#include <map>

class Solution {
public:
  int rotatedDigits(int n) {
    std::map<int, int> assoc = {
      {0, 0},
      {1, 1},
      {2, 5},
      {3, -1},
      {4, -1},
      {5, 2},
      {6, 9},
      {7, -1},
      {8, 8},
      {9, 6}
    };

    int result = 0;

    for (int i = 1; i <= n; i++) {
      int rotated = 0;
      int current = i;
      int mult = 1;
      bool invalid = false;

      while(current > 0) {
        int digit = assoc[current % 10];

        if (digit == -1) {
          invalid = true;
        }

        rotated += digit * mult;
        mult *= 10;
        current /= 10;
      }

      if (!invalid && rotated != i) {
        result++;
      }
    }

    return result;
  }
};
