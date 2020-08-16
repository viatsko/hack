/**
 * @param {number[][]} A
 * @return {number[][]}
 */
const flipAndInvertImage = function(A) {
  for (let i = 0; i < A.length; i++) {
    const rowLen = A[0].length - 1;
    for (let j = 0; j <= rowLen >> 1; j++) {
      const tmp = A[i][j] ^ 1;
      A[i][j] = A[i][rowLen - j] ^ 1;
      A[i][rowLen - j] = tmp;
    }
  }

  return A;
};
