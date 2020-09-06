/**
 * // This is the CustomFunction's API interface.
 * // You should not implement it, or speculate about its implementation
 * function CustomFunction() {
 *     @param {integer, integer} x, y
 *     @return {integer}
 *     this.f = function(x, y) {
 *         ...
 *     };
 * };
 */

/**
 * @param {CustomFunction} customfunction
 * @param {integer} z
 * @return {integer[][]}
 */
var findSolution = function (customfunction, z) {
  const res = [];

  for (let x = 1, y = 1000; x <= 1000, y >= 1; ) {
    const ans = customfunction.f(x, y);

    if (ans < z) {
      x++;
    } else if (ans > z) {
      y--;
    } else {
      res.push([x, y]);
      x++;
      y--;
    }
  }

  return res;
};
