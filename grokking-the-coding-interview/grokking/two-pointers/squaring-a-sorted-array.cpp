using namespace std;

#include <iostream>
#include <vector>

class SortedArraySquares {
 public:
  static vector<int> makeSquares(const vector<int>& arr) {
    int n = arr.size();
    vector<int> result(n);

    int resultIndex = result.size() - 1;

    int left = 0;
    int right = arr.size() - 1;
    while (left < right) {
      if (abs(arr[left]) > abs(arr[right])) {
        result[resultIndex--] = arr[left] * arr[left];
        left++;
      } else {
        result[resultIndex--] = arr[right] * arr[right];
        right--;
      }
    }

    return result;
  }
};
