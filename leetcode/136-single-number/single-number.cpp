#include <vector>

class Solution {
public:
  int singleNumber(std::vector<int>& nums) {
    int result = 0;

    for (auto num : nums) {
      result ^= num;
    }

    return result;
  }
};
