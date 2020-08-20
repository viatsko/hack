#include <iostream>
#include <vector>

class Solution {
public:
  int totalHammingDistance(std::vector<int>& nums) {
    int result = 0;
    int n = nums.size();

    for (int i = 0; i < 31; i++) {
      int current = 0;

      for (int j = 0; j < n; j++) {
        if (nums[j] & (1 << i) != 0) {
          current++;
        }
      }

      result += current * (n - current);
    }

    return result;
  }
};
