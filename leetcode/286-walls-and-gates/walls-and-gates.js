const dirs = [
  [1, 0],
  [-1, 0],
  [0, 1],
  [0, -1]
];

const isValid = (grid, i, j) => {
  if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] === 2147483647) {
    return true;
  }
  return false;
};

const getNeighbours = (grid, i, j) => {
  return dirs.map(([offsetX, offsetY]) => [offsetX + i, offsetY + j]).filter(([i, j]) => isValid(grid, i, j));
};

const bfs = (grid, q) => {
  while (q.length) {
    const [x, y] = q.shift();
    const neighbours = getNeighbours(grid, x, y);
    for (const [nx, ny] of neighbours) {
      grid[nx][ny] = grid[x][y] + 1;
      q.push([nx, ny]);
    }
  }
};

/**
 * @param {number[][]} rooms
 * @return {void} Do not return anything, modify rooms in-place instead.
 */
const wallsAndGates = function(rooms) {
  const q = [];

  for (let i = 0; i < rooms.length; i++) {
    for (let j = 0; j < rooms[0].length; j++) {
      if (rooms[i][j] === 0) {
        q.push([i, j]);
      }
    }
  }

  bfs(rooms, q);
};
