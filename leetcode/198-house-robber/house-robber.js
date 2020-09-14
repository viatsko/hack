/**
 * @param {number[]} nums
 * @return {number}
 */
const rob = function (nums) {
  if (nums.length === 0) {
    return 0;
  }

  if (nums.length === 1) {
    return nums[0];
  }

  if (nums.length < 2) {
    return Math.max(nums[0], nums[1]);
  }

  const dp = [nums[0], nums[1]];

  for (let i = 2; i < nums.length; i++) {
    dp[i] =
      (i < nums.length ? nums[i] : 0) +
      Math.max(dp[i - 2], dp[i - 3] ? dp[i - 3] : 0);
  }

  return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
};
