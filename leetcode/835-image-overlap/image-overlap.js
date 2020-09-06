/**
 * @param {number[][]} C
 * @param {number[][]} D
 * @param {number} shiftX
 * @param {number} shiftY
 * @return {number}
 */
const calculateOverlap = function (C, D, shiftX, shiftY) {
  let cnt = 0;

  for (let i = shiftX; i < C.length; i++) {
    for (let j = shiftY; j < C.length; j++) {
      if (C[i][j] === D[i - shiftX][j - shiftY] && C[i][j] === 1) {
        cnt++;
      }
    }
  }

  return cnt;
};

/**
 * @param {number[][]} A
 * @param {number[][]} B
 * @return {number}
 */
const largestOverlap = function (A, B) {
  let max = 0;

  for (let i = 0; i < A.length; i++) {
    for (let j = 0; j < B.length; j++) {
      max = Math.max(max, calculateOverlap(A, B, i, j));
      max = Math.max(max, calculateOverlap(B, A, i, j));
    }
  }

  return max;
};
