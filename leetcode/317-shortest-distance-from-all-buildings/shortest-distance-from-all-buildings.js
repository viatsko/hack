/**
 * @param {number[][]} grid
 * @return {number}
 */
const shortestDistance = function (grid) {
  let numberOfBuildings = 0;

  const reach = new Array(grid.length).fill(0).map(row => new Array(grid[0].length).fill(0));
  const distance = new Array(grid.length).fill(0).map(row => new Array(grid[0].length).fill(0));

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (grid[i][j] === 1) {
        numberOfBuildings++;
        const visited = new Array(grid.length).fill(0).map(row => new Array(grid[0].length).fill(false));

        const q = [];
        q.push([i, j]);

        let level = 0;
        while (q.length > 0) {
          const size = q.length;

          for (let k = 0; k < size; k++) {
            const curr = q.shift();

            if (curr[0] >= 0 && curr[1] >= 0 && curr[0] < grid.length && curr[1] < grid[0].length && (grid[curr[0]][curr[1]] === 0 || (curr[0] === i && curr[1] === j)) && !visited[curr[0]][curr[1]]) {
              visited[curr[0]][curr[1]] = true;
              reach[curr[0]][curr[1]]++;
              distance[curr[0]][curr[1]] += level;

              q.push([curr[0] - 1, curr[1]]);
              q.push([curr[0], curr[1] - 1]);
              q.push([curr[0] + 1, curr[1]]);
              q.push([curr[0], curr[1] + 1]);
            }
          }

          level++;
        }
      }
    }
  }

  console.log(distance);
  console.log(reach);

  let shortest = Number.MAX_SAFE_INTEGER;

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (grid[i][j] === 0 && reach[i][j] === numberOfBuildings) {
        shortest = Math.min(shortest, distance[i][j]);
      }
    }
  }

  return shortest === Number.MAX_SAFE_INTEGER ? -1 : shortest;
};
