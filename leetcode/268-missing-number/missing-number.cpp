class Solution {
public:
  int missingNumber(vector<int>& nums) {
    int i = 0;
    while (i < nums.size()) {
      if (nums[i] < nums.size() && nums[i] != nums[nums[i]]) {
        swap(nums[i], nums[nums[i]]);
      } else {
        i++;
      }
    }

    for (int i = 0; i < nums.size(); i++) {
      if (nums[i] != i) {
        return i;
      }
    }

    return nums.size();
  }
};
