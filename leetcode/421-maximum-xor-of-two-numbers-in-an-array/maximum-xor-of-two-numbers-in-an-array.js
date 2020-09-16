/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaximumXOR = function (nums) {
  let max = 0;

  for (let i = 0; i < nums.length - 1; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      max = Math.max(nums[i] ^ nums[j], max);
    }
  }

  return max;
};
