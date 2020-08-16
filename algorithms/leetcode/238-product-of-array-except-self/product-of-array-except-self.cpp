#include <vector>

class Solution {
public:
  std::vector<int> productExceptSelf(std::vector<int>& nums) {
    std::vector<int> result(nums.size(), 1);

    for (std::vector<int>::size_type i = 0; i < nums.size() - 1; i++) {
      result[i + 1] = result[i] * nums[i];
    }

    int product = 1;
    for (std::vector<int>::size_type i = nums.size(); i > 0; i--) {
      result[i - 1] *= product;
      product *= nums[i - 1];
    }

    return result;
  }
};
