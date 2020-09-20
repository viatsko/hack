using namespace std;

#include <iostream>
#include <vector>

class PairWithTargetSum {
 public:
  static pair<int, int> search(const vector<int>& arr, int targetSum) {
    int left = 0;
    int right = arr.size() - 1;

    while (left < right) {
      int sum = arr[left] + arr[right];

      if (sum == targetSum) {
        return make_pair(left, right);
      } else if (sum > targetSum) {
        right--;
      } else {
        left++;
      }
    }

    return make_pair(-1, -1);
  }
};
