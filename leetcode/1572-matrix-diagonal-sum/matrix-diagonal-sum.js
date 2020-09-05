/**
 * @param {number[][]} mat
 * @return {number}
 */
var diagonalSum = function (mat) {
  let res = 0;

  for (let i = 0; i < mat.length; i++) {
    res +=
      mat[i][i] + (i !== mat.length - i - 1 ? mat[i][mat.length - i - 1] : 0);
  }

  return res;
};
