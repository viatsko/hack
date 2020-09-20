class Solution {
public:
  int numSubarrayProductLessThanK(vector<int>& nums, int k) {
    int result = 0;

    int product = 1;
    int left = 0;

    for (int right = 0; right < nums.size(); right++) {
      product *= nums[right];

      while (product >= k && left < nums.size()) {
        product /= nums[left++];
      }

      if (product < k) {
        result += right - left + 1;
      }
    }

    return result;
  }
};
