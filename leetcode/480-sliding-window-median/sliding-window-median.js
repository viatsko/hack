/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
const medianSlidingWindow = function (nums, k) {
  let windowStart = 0;
  let windowEnd = 0;
  const result = [];
  const window = [];
  for (windowEnd = 0; windowEnd < nums.length; windowEnd++) {
    window.push(nums[windowEnd]);

    if (windowEnd >= k - 1) {
      const swindow = [...window].sort((a, b) => a - b);
      result.push(
        swindow.length % 2 === 0
          ? (swindow[swindow.length / 2 - 1] + swindow[swindow.length / 2]) / 2
          : swindow[~~(swindow.length / 2)]
      );
      window.shift();
    }
  }
  return result;
};
