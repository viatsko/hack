#include <vector>

class Solution {
public:
  int arrayNesting(std::vector<int>& nums) {
    int result = -1;

    for (std::vector<int>::size_type i = 0; i < nums.size(); i++) {
      int current = 0;

      for (std::vector<int>::size_type j = i, tmp = nums[i]; nums[j] >= 0; j = tmp, current++) {
        tmp = nums[j];
        nums[j] = -1;
      }

      result = std::max(current, result);
    }

    return result;
  }
};
