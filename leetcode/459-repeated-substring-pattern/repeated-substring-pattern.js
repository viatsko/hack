/**
 * @param {string} s
 * @return {boolean}
 */
var repeatedSubstringPattern = function (s) {
  for (let i = 1; i <= s.length / 2; i++) {
    if (s.length % i === 0) {
      console.log(s.substring(0, i));
      if (s === s.substring(0, i).repeat(s.length / i)) {
        return true;
      }
    }
  }

  return false;
};
