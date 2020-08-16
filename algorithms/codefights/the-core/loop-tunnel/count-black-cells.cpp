#include <numeric>

int countBlackCells(int n, int m) {
  return n + m + std::gcd(n, m) - 2;
}
