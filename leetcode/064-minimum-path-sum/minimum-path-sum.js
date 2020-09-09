/**
 * @param {number[][]} grid
 * @return {number}
 */
const minPathSum = function (grid) {
  const dp = Array(grid.length)
    .fill(undefined)
    .map(() => Array(grid[0].length).fill(0));

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (i > 0 && j > 0) {
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      } else {
        dp[i][j] =
          (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0) + grid[i][j];
      }
    }
  }

  return dp[grid.length - 1][grid[0].length - 1];
};
