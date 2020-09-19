/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const numSubseq = function (nums, target) {
  const modPow = [];
  modPow[0] = 1;
  for (let i = 1; i < nums.length; i++) {
    modPow[i] = (2 * modPow[i - 1]) % 1000000007;
  }

  nums.sort((a, b) => a - b);

  let result = 0;

  let left = 0;
  let right = nums.length - 1;

  while (left <= right) {
    if (nums[left] + nums[right] <= target) {
      result += modPow[right - left];
      left++;
    } else {
      right--;
    }
  }

  return result % 1000000007;
};
