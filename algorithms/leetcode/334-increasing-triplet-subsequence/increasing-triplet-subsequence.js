/**
 * @param {number[]} nums
 * @return {boolean}
 */
const increasingTriplet = function(nums) {
  let max1 = Number.MAX_SAFE_INTEGER;
  let max2 = Number.MAX_SAFE_INTEGER;

  for (const num of nums) {
    if (num <= max1) {
      max1 = num;
    } else if (num <= max2) {
      max2 = num;
    } else {
      return true;
    }
  }

  return false;
};