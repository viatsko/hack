const searchMatrix = function (matrix, target) {
  if (!matrix.length) {
    return false;
  }

  const helper = function (left, right, up, down) {
    if (
      left > right ||
      up > down ||
      matrix[up][left] > target ||
      matrix[down][right] < target
    ) {
      return false;
    }

    const mid = Math.floor((right + left) / 2);

    let row = up;
    while (row <= down && matrix[row][mid] <= target) {
      if (matrix[row][mid] === target) {
        return true;
      }

      row++;
    }

    return (
      helper(left, mid - 1, row, down) || helper(mid + 1, right, up, row - 1)
    );
  };

  return helper(0, matrix[0].length - 1, 0, matrix.length - 1);
};
