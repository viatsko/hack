const hasZeroes = function(num) {
  return ('' + num).indexOf('0') !== -1;
}

/**
 * @param {number} n
 * @return {number[]}
 */
const getNoZeroIntegers = function(n) {
  let left = 1;
  let right = n - left;

  while (left <= right) {
    if (!hasZeroes(left) && !hasZeroes(right)) {
      return [left, right];
    }

    left++;
    right--;
  }

  return [-1, -1];
};
