/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const nextPermutation = function (nums) {
  let i = nums.length - 1;
  while (i > 0 && nums[i - 1] >= nums[i]) {
    i--;
  }

  if (i <= 0) {
    nums.reverse();
    return nums;
  }

  let j = nums.length - 1;
  while (nums[j] <= nums[i - 1]) {
    j--;
  }

  [nums[i - 1], nums[j]] = [nums[j], nums[i - 1]];

  j = nums.length - 1;

  while (i < j) {
    [nums[i], nums[j]] = [nums[j], nums[i]];
    i++;
    j--;
  }

  return nums;
};
