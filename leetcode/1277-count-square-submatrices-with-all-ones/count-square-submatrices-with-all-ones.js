/**
 * @param {number[][]} matrix
 * @return {number}
 */
const countSquares = function (matrix) {
  let res = 0;

  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[0].length; j++) {
      if (!matrix[i][j]) continue;

      if (i > 0 && j > 0) {
        matrix[i][j] =
          Math.min(matrix[i - 1][j], matrix[i][j - 1], matrix[i - 1][j - 1]) +
          1;
      }
      res += matrix[i][j];
    }
  }

  console.log(matrix);

  return res;
};

/*
[1,0,1]
[1,1,0]
[1,1,0]

[1,0,1]
[1,0,0]
*/
