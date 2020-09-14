// nums = [4,5,6,7,0,1,2], target = 5
// nums = [7,0,1,2,4,5,6]

// Input: nums = [4,5,6,7,0,1,2], target = 0

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const search = function (nums, target) {
  let left = 0;
  let right = nums.length - 1;

  while (left <= right) {
    const mid = Math.floor(left + (right - left) / 2);
    console.log("mid", mid);

    if (target === nums[mid]) {
      return mid;
    } else if (target > nums[mid]) {
      if (nums[right] >= nums[mid] && target > nums[right]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    } else if (target < nums[mid]) {
      // 0 < 7
      if (nums[left] <= nums[mid] && target < nums[left]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
  }

  return -1;
};
