/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
  const result = [];
  const subResult = [];

  const helper = () => {
    if (subResult.length === nums.length) {
      result.push([...subResult]);
      return;
    }

    for (const num of nums) {
      if (subResult.indexOf(num) === -1) {
        subResult.push(num);
        helper();
        subResult.pop();
      }
    }
  };

  helper();

  return result;
};
