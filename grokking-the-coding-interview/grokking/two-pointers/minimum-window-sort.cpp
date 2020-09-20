using namespace std;

#include <iostream>
#include <limits>
#include <vector>

class ShortestWindowSort {
 public:
  static int sort(const vector<int>& arr) {
    int min = numeric_limits<int>::max();
    int max = numeric_limits<int>::min();
    int left = 0;
    int right = arr.size() - 1;
    int begin = 0;
    int end = -1;

    while (right >= 0) {
      min = std::min(min, arr[right]);
      if (arr[right] != min) {
        begin = right;
      }
      max = std::max(max, arr[left]);
      if (arr[left] != max) {
        end = left;
      }

      right--;
      left++;
    }

    return end - begin + 1;
  }
};
