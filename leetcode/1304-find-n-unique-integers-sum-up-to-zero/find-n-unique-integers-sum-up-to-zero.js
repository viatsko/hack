/**
 * @param {number} n
 * @return {number[]}
 */
var sumZero = function(n) {
  const result = [];
  const mid = n >>> 1;
  if (n % 2 === 1) {
    result[mid] = 0;
  }

  for (let i = 0, k = 1; i < mid; i++, k++) {
    result[i] = k;
    result[n - i - 1] = -k;
  }

  return result;
};
