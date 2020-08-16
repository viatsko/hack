#include <vector>

int houseRobber(std::vector<int> nums) {
  int odd = 0;
  int even = 0;

  for (std::vector<int>::size_type i = 0; i < nums.size(); i++) {
    if (i % 2 == 0) {
      even = std::max(even + nums[i], odd);
    } else {
      odd = std::max(odd + nums[i], even);
    }
  }

  return std::max(even, odd);
}
