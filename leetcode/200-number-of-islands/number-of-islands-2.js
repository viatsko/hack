/**
 * @param {character[][]} grid
 * @return {number}
 */
const numIslands = function(grid) {
  let result = 0;
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (grid[i][j] === "1") {
        result++;

        grid[i][j] = "0";

        const q = [[i, j]];

        while(q.length) {
          const [cx, cy] = q.shift();

          for (const [x, y] of ([
            [1, 0],
            [0, 1],
            [-1, 0],
            [0, -1]
          ].map(([ox, oy]) => [cx + ox, cy + oy])
            .filter(([x, y]) => x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] === "1"))
            ) {
            grid[x][y] = "0";
            q.push([x, y]);
          }
        }
      }
    }
  }
  return result;
};
