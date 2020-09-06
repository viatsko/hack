/**
 * @param {number[][]} grid
 * @return {number}
 */
const projectionArea = function (grid) {
  let result = 0;

  for (let i = 0; i < grid.length; i++) {
    let x = 0;
    let y = 0;

    for (let j = 0; j < grid[0].length; j++) {
      x = Math.max(x, grid[i][j]);
      y = Math.max(y, grid[j][i]);

      if (grid[i][j] > 0) {
        result += 1;
      }
    }

    result += x + y;
  }

  return result;
};
