#include <vector>

std::vector<int> concatenateArrays(std::vector<int> a, std::vector<int> b) {
  a.insert(a.end(), b.begin(), b.end());

  return a;
}
