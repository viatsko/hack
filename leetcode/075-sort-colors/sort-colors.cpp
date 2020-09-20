class Solution {
public:
  void sortColors(vector<int>& nums) {
    int left = 0;
    int right = nums.size() - 1;
    for (int i = 0; i <= right;) {
      if (nums[i] == 0) {
        swap(nums[i], nums[left]);
        i++;
        left++;
      } else if (nums[i] == 1) {
        i++;
      } else {
        swap(nums[i], nums[right]);
        right--;
      }
    }
  }
};
