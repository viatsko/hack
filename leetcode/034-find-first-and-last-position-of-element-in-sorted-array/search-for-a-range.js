/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const searchRange = function (nums, target) {
  return [findLeft(nums, target), findRight(nums, target)];
};

const findLeft = function (nums, target) {
  let left = 0;
  let right = nums.length - 1;

  if (nums[0] === target) {
    return 0;
  }

  while (left <= right) {
    const mid = Math.floor(left + (right - left) / 2);

    if (nums[mid - 1] !== target && nums[mid] === target) {
      return mid;
    } else if (nums[mid] < target) {
      left = mid + 1;
    } else if (nums[mid] >= target) {
      right = mid - 1;
    }
  }

  return -1;
};

const findRight = function (nums, target) {
  let left = 0;
  let right = nums.length - 1;

  if (nums[nums.length - 1] === target) {
    return nums.length - 1;
  }

  while (left <= right) {
    const mid = Math.floor(left + (right - left) / 2);

    if (nums[mid + 1] !== target && nums[mid] === target) {
      return mid;
    } else if (nums[mid] > target) {
      right = mid - 1;
    } else if (nums[mid] <= target) {
      left = mid + 1;
    }
  }

  return -1;
};
