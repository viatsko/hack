const isValid = function (matrix, i, j) {
  if (
    !matrix.length ||
    !matrix[0].length ||
    i < 0 ||
    j < 0 ||
    i >= matrix.length ||
    j >= matrix[0].length
  ) {
    return false;
  }

  return true;
};

const collect = function (matrix, i, j, goUp) {
  const result = [];
  while (isValid(matrix, i, j)) {
    result.push(matrix[i][j]);
    i -= 1;
    j += 1;
  }
  return !goUp ? result.reverse() : result;
};

/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
const findDiagonalOrder = function (matrix) {
  if (matrix.length === 1) {
    return matrix[0];
  }
  const result = [];
  let goUp = true;
  for (let i = 0; i < matrix.length - 1; i++) {
    result.push(...collect(matrix, i, 0, goUp));
    goUp = !goUp;
  }
  if (matrix.length > 1) {
    for (let i = 0; i < matrix[0].length; i++) {
      result.push(...collect(matrix, matrix.length - 1, i, goUp));
      goUp = !goUp;
    }
  }
  return result;
};
