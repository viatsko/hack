/**
 * @param {number[]} nums
 * @return {number}
 */
const dominantIndex = function (nums) {
  let max, maxOld;
  let maxIdx = 0;
  max = maxOld = Number.MIN_SAFE_INTEGER;

  if (nums.length === 1) {
    return 0;
  }

  for (let i = 0; i < nums.length; i++) {
    if (nums[i] > max) {
      maxOld = max;
      maxIdx = i;
      max = nums[i];
    } else if (nums[i] > maxOld) {
      maxOld = nums[i];
    }
  }

  return max >= maxOld * 2 ? maxIdx : -1;
};
