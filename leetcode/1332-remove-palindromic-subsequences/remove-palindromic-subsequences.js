/**
 * @param {string} s
 * @return {number}
 */
const removePalindromeSub = function (s) {
  if (s.length === 0) {
    return 0;
  } else {
    const rv = s.split("").reverse().join("");
    if (s === rv) {
      return 1;
    } else {
      return 2;
    }
  }
};
