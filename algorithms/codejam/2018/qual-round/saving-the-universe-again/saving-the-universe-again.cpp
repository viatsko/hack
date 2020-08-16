#include <iostream>
#include <string>

int checkPossibility(long d, std::string p) {
  long totalDamage = 0;
  int swaps = 0;

  while (true) {
    long s = 1;
    totalDamage = 0;

    for (const auto& ch : p) {
      if (ch == 'S') {
        totalDamage += s;
      } else {
        s *= 2;
      }
    }

    if (totalDamage <= d) {
      return swaps;
    } else {
      std::string::size_type i;
      for (i = p.size() - 1; i > 0; i--) {
        if (p[i] == 'S' && p[i - 1] == 'C') {
          char tmp = p[i];
          p[i] = p[i - 1];
          p[i - 1] = tmp;
          swaps++;
          break;
        }
      }

      if (i == 0) {
        return -1;
      }
    }
  }
}

int main() {
  long t;

  std::cin >> t;

  for (long i = 1; i <= t; i++) {
    long d;

    std::string p;

    std::cin >> d >> p;

    int possibility = checkPossibility(d, p);

    std::cout << "Case #" << i << ": ";

    if (possibility == -1) {
      std::cout << "IMPOSSIBLE";
    } else {
      std::cout << possibility;
    }

    std::cout << std::endl;
  }

  return 0;
}
