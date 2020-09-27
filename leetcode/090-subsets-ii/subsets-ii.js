/**
 * @param {number[]} nums
 * @return {number[][]}
 */
const subsetsWithDup = function (nums) {
  nums.sort((a, b) => a - b);

  const result = [];
  result.push([]);

  let startIndex = 0;
  let endIndex = 0;
  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];
    startIndex = 0;
    if (i > 0 && num === nums[i - 1]) {
      startIndex = endIndex + 1;
    }
    endIndex = result.length - 1;
    for (let j = startIndex; j <= endIndex; j++) {
      result.push([...result[j], num]);
    }
  }

  return result;
};
