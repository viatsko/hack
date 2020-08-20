/**
 * @param {number[]} nums
 * @return {number}
 */
const findPeakElement = function(nums) {
  if (nums.length === 1) {
    return 0;
  }

  let min = 0;
  let max = nums.length - 1;

  while (min < max) {
    const mid = (min + max) >> 1;

    if (nums[mid] < nums[mid + 1]) {
      min = mid + 1;
    } else {
      max = mid;
    }
  }

  return min;
};
