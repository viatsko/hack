class Solution {
public:
  vector<int> majorityElement(vector<int>& nums) {
    int max1 = numeric_limits<int>::min();
    int max2 = numeric_limits<int>::min();
    int count1 = 0;
    int count2 = 0;

    for (int num : nums) {
      if (num == max1) {
        count1++;
      }  else if (num == max2) {
        count2++;
      } else if (count1 == 0) {
        max1 = num;
        count1 = 1;
      } else if (count2 == 0) {
        max2 = num;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }

    int lb = nums.size() / 3;
    vector<int> result;
    if (std::count(nums.begin(), nums.end(), max1) > lb) {
      result.push_back(max1);
    }
    if (max1 != max2 && std::count(nums.begin(), nums.end(), max2) > lb) {
      result.push_back(max2);
    }
    return result;
  }
};
