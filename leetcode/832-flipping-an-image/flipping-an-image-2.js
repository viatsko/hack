/**
 * @param {number[][]} A
 * @return {number[][]}
 */
var flipAndInvertImage = function(A) {
  return A.map(row => row.reverse().map(i => i === 0 ? 1 : 0));
};
