#include <cstddef>

int largestNumber(int n) {
  int result = 0;

  for (std::size_t i = 0; i < n; i++) {
    result *= 10;
    result += 9;
  }

  return result;
}
