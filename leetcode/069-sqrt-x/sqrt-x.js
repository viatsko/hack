/**
 * @param {number} x
 * @return {number}
 */
const mySqrt = function (x) {
  let left = 0;
  let right = x;

  let result = 0;
  while (left <= right) {
    const mid = Math.floor((right + left) / 2);

    const mult = mid * mid;

    if (mult <= x) {
      left = mid + 1;
      result = mid;
    } else {
      right = mid - 1;
    }
  }

  return result;
};
