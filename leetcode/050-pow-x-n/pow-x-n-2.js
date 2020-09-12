const fastPow = function (x, n) {
  if (n === 0) {
    return 1;
  }

  const result = fastPow(x, Math.floor(n / 2));

  return n % 2 === 0 ? result * result : result * result * x;
};

/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
const myPow = function (x, n) {
  if (n === 0) {
    return 1;
  }

  if (n < 0) {
    n = Math.abs(n);
    x = 1 / x;
  }

  return fastPow(x, n);
};
