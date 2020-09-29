const dirs = [
  [-1, 0],
  [0, -1],
  [1, 0],
  [0, 1],
];

/**
 * @param {number[][]} grid
 * @return {number}
 */
const getMaximumGold = function (grid) {
  let max = 0;

  const visited = new Array(grid.length)
    .fill(true)
    .map((row) => new Array(grid[0].length).fill(false));

  const getNeighbours = function (x, y) {
    const result = [];
    for (const dir of dirs) {
      const newX = x + dir[0];
      const newY = y + dir[1];

      if (
        newX >= 0 &&
        newY >= 0 &&
        newX < grid.length &&
        newY < grid[0].length &&
        grid[newX][newY] !== 0 &&
        !visited[newX][newY]
      ) {
        result.push([newX, newY]);
      }
    }
    return result;
  };

  let current = 0;
  const explore = function (startX, startY) {
    const currValue = grid[startX][startY];
    current += currValue;

    max = Math.max(current, max);

    visited[startX][startY] = true;

    const neighbours = getNeighbours(startX, startY);

    for (const [x, y] of neighbours) {
      explore(x, y);
    }

    visited[startX][startY] = false;

    current -= currValue;
  };

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (grid[i][j] !== 0) {
        explore(i, j);
      }
    }
  }

  return max;
};
