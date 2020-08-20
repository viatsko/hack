#include <vector>
#include <unordered_map>

class Solution {
public:
  int maxSubArrayLen(std::vector<int>& nums, int k) {
    std::unordered_map<int, int> mp;

    int sum = 0;
    int result = 0;

    for (int i = 0; i < nums.size(); i++) {
      sum += nums[i];

      if (sum == k) {
        result = i + 1;
      } else if (mp.find(sum - k) != mp.end()) {
        result = std::max(result, i - mp[sum - k]);
      }

      if (mp.find(sum) == mp.end()) {
        mp[sum] = i;
      }
    }

    return result;
  }
};
