#include <cmath>

int phoneCall(int min1, int min2_10, int min11, int s) {
  int result = 0;

  if (s >= min1) {
    s -= min1;

    result += 1;

    if (s >= min2_10) {
      int total_min2_10 = s / min2_10;

      int actual_min2_10 = std::min(s / min2_10, 9);

      s -= min2_10 * actual_min2_10;
      result += actual_min2_10;

      if (s >= min11 && total_min2_10 > 9) {
        int total_min11 = s / min11;

        result += total_min11;
      }
    }
  }

  return result;
}
