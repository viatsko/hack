/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const search = function(nums, target) {
  let rotation;

  {
    let min = 0;
    let max = nums.length - 1;

    while (min < max) {
      const mid = (min + max) >> 1;

      if (nums[mid] > nums[max]) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }

    rotation = min;
  }

  let min = 0;
  let max = nums.length - 1;

  while (min <= max) {
    const mid = (min + max) >> 1;
    const rmid = (mid + rotation) % nums.length;

    if (nums[rmid] === target) {
      return rmid;
    }

    if (nums[rmid] > target) {
      max = mid - 1;
    } else {
      min = mid + 1;
    }
  }

  return -1;
};
