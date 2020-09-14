/**
 * @param {number[]} nums
 * @return {number}
 */
const findPeakElement = function (nums) {
  if (!nums.length) {
    return -1;
  }

  if (nums.length === 1) {
    return 0;
  }

  let left = 0;
  let right = nums.length - 1;

  while (left <= right) {
    const mid = Math.floor(left + (right - left) / 2);

    // Input: nums = [1,2,1,3,5,6,4]

    if (
      (mid === 0 && nums[mid + 1] < nums[mid]) ||
      (mid === nums.length - 1 && nums[mid - 1] < nums[mid]) ||
      (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
    ) {
      return mid;
    } else if (nums[mid + 1] > nums[mid]) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return -1;
};
