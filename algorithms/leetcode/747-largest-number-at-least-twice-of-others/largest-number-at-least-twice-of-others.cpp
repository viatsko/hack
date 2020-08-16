#include <vector>

class Solution {
public:
  int dominantIndex(std::vector<int>& nums) {
    if (nums.size() == 0) {
      return -1;
    }

    if (nums.size() == 1) {
      return 0;
    }

    int max1 = -1;
    int max1i = 0;
    int max2 = -1;

    for (std::vector<int>::size_type i = 0; i < nums.size(); i++) {
      if (nums[i] > max1) {
        max2 = max1;
        max1 = nums[i];
        max1i = i;
      } else if(nums[i] != max1 && nums[i] > max2){
        max2 = nums[i];
      }
    }

    if (max1 == -1 || max2 == -1) {
      return -1;
    }

    return max1 >= max2 * 2 ? max1i : -1;
  }
};
