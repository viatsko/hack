#include <algorithm>
#include <vector>

class Solution {
private:
  std::vector<int> nums;
public:
  Solution(std::vector<int> nums) {
    this->nums = nums;
  }

  /** Resets the array to its original configuration and return it. */
  std::vector<int> reset() {
    return nums;
  }

  /** Returns a random shuffling of the array. */
  std::vector<int> shuffle() {
    std::vector<int> numsCopy(this->nums);
    std::random_shuffle(numsCopy.begin(), numsCopy.end());
    return numsCopy;
  }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * vector<int> param_1 = obj.reset();
 * vector<int> param_2 = obj.shuffle();
 */
