#include <cmath>
#include <iostream>
#include <vector>

int main(int argc, char * argv[]) {
  std::ios_base::sync_with_stdio (false);

  #ifdef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
  #endif

  long long n;
  std::cin >> n;

  int result = 0;

  long x = 2;

  long max = (long)std::sqrt(std::sqrt((double)n));
  while (x <= max) {
    int c = 0;

    for (long i = 2; i <= x; i++) {
      if (x % i == 0) {
        c += 1;
      }

      if (c > 1) {
        break;
      }
    }

    if (c == 1) {
      result++;
    }

    x++;
  }

  std::cout << result << std::endl;

  return 0;
}
