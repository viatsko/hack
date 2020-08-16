#include <vector>

class Solution {
public:
  int removeDuplicates(std::vector<int>& nums) {
    std::vector<int>::size_type slow = 0;
    for (std::vector<int>::size_type i = 0; i < nums.size();) {
      int current = nums[i];
      int count = 0;

      std::vector<int>::size_type j;
      for (; nums[i] == current && i < nums.size(); i++) {
        if (count++ < 2) {
          nums[slow++] = current;
        }
      }
    }

    return slow;
  }
};
