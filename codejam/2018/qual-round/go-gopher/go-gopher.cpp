#include <iostream>
#include <string>
#include <vector>

int main() {
  std::ios_base::sync_with_stdio (false);

  int t;

  std::cin >> t;

  while (t-- > 0) {
    int a;
    std::cin >> a;

    std::vector<std::vector<bool>> v(
      std::max((a + 2) / 3, 3) + 1,
      std::vector<bool>(3, false)
    );

    for(int x = 1;;) {
      std::cout << x + 1 << " 2" << std::endl;

      int i, j;
      std::cin >> i >> j;

      if(i == -1) {
        return 0;
      } else if (i == 0 && j == 0) {
        break;
      }

      v[i - 1][j - 1] = true;

      if(j == 2) { // middle-point, 2 equals to 1 in vector
        // if we are at middle-point,
        // scan 3 x 3 area and check if it's prepared
        bool fullyPrepared = true;

        for (int i = x - 1; i <= x + 1; i++) {
          for (int j = 0; j < 3; j++) {
            if (!v[i][j]) {
              fullyPrepared = false;
            }
          }
        }

        if (fullyPrepared) {
          x += 2;
        }
      }
    }
  }

  return 0;
}
