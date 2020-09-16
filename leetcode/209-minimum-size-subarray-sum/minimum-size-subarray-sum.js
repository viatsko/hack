/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
const minSubArrayLen = function (s, nums) {
  let result = Number.MAX_SAFE_INTEGER;

  let sum = 0;

  let left = 0;
  let right = 0;

  while (right < nums.length) {
    sum += nums[right++];

    while (sum >= s) {
      sum -= nums[left++];
      result = Math.min(result, right - left + 1);
    }
  }

  return result === Number.MAX_SAFE_INTEGER ? 0 : result;
};
