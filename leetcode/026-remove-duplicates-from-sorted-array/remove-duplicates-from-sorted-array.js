/**
 * @param {number[]} nums
 * @return {number}
 */
const removeDuplicates = function(nums) {
  let j = 1;
  for (let i = 1; i < nums.length; i++) {
    if (nums[i - 1] !== nums[i]) {
      nums[j++] = nums[i]
    }
  }
  return j;
};
