/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
var buildArray = function (target, n) {
  const result = [];
  let j = 0;
  for (let i = 1; i <= n; i++) {
    if (target[j] === i) {
      result.push("Push");
      j++;
      if (j === target.length) {
        return result;
      }
    } else {
      result.push("Push");
      result.push("Pop");
    }
  }
  return result;
};
