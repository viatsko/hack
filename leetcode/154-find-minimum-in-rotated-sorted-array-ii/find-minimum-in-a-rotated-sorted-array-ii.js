/**
 * @param {number[]} nums
 * @return {number}
 */
const findMin = function (nums) {
  if (nums.length === 1) {
    return nums[0];
  }

  let left = 0;
  let right = nums.length - 1;

  while (left < right) {
    const mid = Math.floor(left + (right - left) / 2);

    if (nums[mid] < nums[right]) {
      right = mid;
    } else if (nums[mid] > nums[right]) {
      left = mid + 1;
    } else {
      right--;
    }
  }

  return nums[right];
};
