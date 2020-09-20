using namespace std;

#include <algorithm>
#include <iostream>
#include <vector>

class CyclicSort {
 public:
  static void sort(vector<int> &nums) {
    int i = 0;
    while (i < nums.size()) {
      int j = nums[i] - 1;
      if (nums[i] != nums[j]) {
        swap(nums[i], nums[j]);
      } else {
        i++;
      }
    }
  }
};
