/**
 * @param {number[][]} mat
 * @param {number} K
 * @return {number[][]}
 */
const matrixBlockSum = function (mat, K) {
  const sums = Array(mat.length + 1)
    .fill()
    .map(() => Array(mat[0].length + 1).fill(0));

  for (let i = 0; i < mat.length; i++) {
    for (let j = 0; j < mat[0].length; j++) {
      sums[i + 1][j + 1] =
        sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + mat[i][j];
    }
  }

  const ans = Array(mat.length)
    .fill()
    .map(() => Array(mat[0].length).fill(0));
  for (let i = 0; i < mat.length; i++) {
    for (let j = 0; j < mat[0].length; j++) {
      const r1 = Math.max(0, i - K);
      const r2 = Math.min(mat.length, i + K + 1);
      const c1 = Math.max(0, j - K);
      const c2 = Math.min(mat[0].length, j + K + 1);

      ans[i][j] = sums[r2][c2] - sums[r1][c2] - sums[r2][c1] + sums[r1][c1];
    }
  }

  return ans;
};
