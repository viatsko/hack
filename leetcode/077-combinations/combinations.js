/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
const combine = function (n, k) {
  const nums = [...Array(n + 1).keys()];
  nums.shift();

  const result = [];
  const subResult = [];
  const backtrack = (start, k) => {
    if (k === 0) {
      result.push([...subResult]);
      return;
    }

    for (let i = start; i < nums.length; i++) {
      subResult.push(nums[i]);

      backtrack(i + 1, k - 1);

      subResult.pop();
    }
  };

  backtrack(0, k);

  return result;
};
