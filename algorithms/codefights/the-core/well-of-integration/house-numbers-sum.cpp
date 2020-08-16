#include <vector>

int houseNumbersSum(std::vector<int> inputArray) {
  int result = 0;

  for (auto num : inputArray) {
      if (num == 0) {
          break;
      }

      result += num;
  }

  return result;
}
