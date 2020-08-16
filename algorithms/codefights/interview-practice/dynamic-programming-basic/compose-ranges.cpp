#include <sstream>
#include <vector>

std::vector<std::string> composeRanges(std::vector<int> nums) {
  std::vector<std::string> result;

  std::vector<int>::size_type n = nums.size();

  for (std::vector<int>::size_type i = 0; i < n; i++) {
    int start = nums[i];
    int end = start;

    while ((i < n - 1) && (nums[i + 1] - nums[i] == 1)) {
      end = nums[i + 1];
      i++;
    }

    std::ostringstream oss;
    oss << start;

    if (start != end) {
      oss << "->";
      oss << end;
    }

    result.push_back(oss.str());
  }

  return result;
}
