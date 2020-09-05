/**
 * @param {string} s
 * @return {number}
 */
var maxPower = function (s) {
  let prev = "";
  let count = 0;
  let result = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] !== prev) {
      count = 1;
      prev = s[i];
    } else {
      count++;
    }

    result = Math.max(count, result);
  }
  return result;
};
