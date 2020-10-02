/**
 * @param {number[][]} mat
 * @return {number}
 */
const numSpecial = function (mat) {
  const rows = new Array(mat.length).fill(0);
  const cols = new Array(mat[0].length).fill(0);

  for (let i = 0; i < mat.length; i++) {
    for (let j = 0; j < mat[0].length; j++) {
      rows[i] += mat[i][j];
      cols[j] += mat[i][j];
    }
  }

  let result = 0;
  for (let i = 0; i < mat.length; i++) {
    for (let j = 0; j < mat[0].length; j++) {
      if (mat[i][j] === 1 && rows[i] === 1 && cols[j] === 1) {
        result++;
      }
    }
  }
  return result;
};
