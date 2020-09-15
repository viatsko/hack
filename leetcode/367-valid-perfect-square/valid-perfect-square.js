/**
 * @param {number} num
 * @return {boolean}
 */
const isPerfectSquare = function (num) {
  let l = 0;
  let r = num;

  while (l <= r) {
    const mid = Math.floor(l + (r - l) / 2);
    const result = mid * mid;

    if (result === num) {
      return true;
    } else if (result > num) {
      r = mid - 1;
    } else {
      l = mid + 1;
    }
  }

  return false;
};
