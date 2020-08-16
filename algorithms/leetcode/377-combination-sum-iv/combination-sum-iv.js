/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const combinationSum4 = function(nums, target) {
  // has to be structured this way
  // b/c of leetcode environment -.-, no need to structure
  // like this in a real world for rec dp

  if (nums.length === 0) {
    return 0;
  }

  const dp = {};

  const solve = (nums, target) => {
    if (target < 0) {
      return 0;
    }

    if (target === 0) {
      return 1;
    }

    if (dp.hasOwnProperty(target)) {
      return dp[target];
    }

    let count = 0;

    for (let i = 0; i < nums.length; i++) {
      count += solve(nums, target - nums[i]);
    }

    dp[target] = count;

    return count;
  };

  return solve(nums, target);
};
