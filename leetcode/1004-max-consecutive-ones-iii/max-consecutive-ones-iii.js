/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
const longestOnes = function (A, K) {
  let maxLength = 0;
  let spaces = 0;
  let windowStart = 0;
  let windowEnd = 0;
  for (windowEnd = 0; windowEnd < A.length; windowEnd++) {
    spaces += A[windowEnd] === 0 ? 1 : 0;

    while (spaces > K) {
      if (A[windowStart] === 0) {
        spaces--;
      }
      windowStart++;
    }

    maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
  }
  return maxLength;
};
