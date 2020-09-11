/**
 * @param {number[]} nums
 * @return {number}
 */
const maxProduct = function (nums) {
  let totalMax = nums[0];

  let curMax = nums[0];
  let curMin = nums[0];

  for (let i = 1; i < nums.length; i++) {
    const newMax = curMax * nums[i];
    const newMin = curMin * nums[i];
    curMax = Math.max(nums[i], newMax, newMin);
    curMin = Math.min(nums[i], newMin, newMax);

    totalMax = Math.max(totalMax, curMax);
  }

  return totalMax;
};
