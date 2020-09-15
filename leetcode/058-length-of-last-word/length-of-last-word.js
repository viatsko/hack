/**
 * @param {string} s
 * @return {number}
 */
const lengthOfLastWord = function (s) {
  return s.trim().split(" ").pop().length;
};
