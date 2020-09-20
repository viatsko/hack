using namespace std;

#include <deque>
#include <iostream>
#include <vector>

class SubarrayProductLessThanK {
 public:
  static vector<vector<int>> findSubarrays(const vector<int>& arr, int target) {
    vector<vector<int>> result;

    int product = 1;
    int left = 0;
    for (int right = 0; right < arr.size(); right++) {
      product *= arr[right];

      while (product >= target && left < arr.size()) {
        product /= arr[left++];
      }

      deque<int> q;
      for (int i = right; i >= left; i--) {
        q.push_front(arr[i]);
        vector<int> subres = {q.begin(), q.end()};
        result.push_back(subres);
      }
    }

    return result;
  }
};
