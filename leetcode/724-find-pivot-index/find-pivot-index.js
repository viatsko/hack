/**
 * @param {number[]} nums
 * @return {number}
 */
const pivotIndex = function (nums) {
  let sum = 0;
  for (let i = 0; i < nums.length; i++) {
    sum += nums[i];
  }

  let leftSum = 0;
  let rightSum = sum;

  for (let i = 0; i < nums.length; i++) {
    if (leftSum === rightSum - leftSum - nums[i]) {
      return i;
    }
    leftSum += nums[i];
  }

  return -1;
};
