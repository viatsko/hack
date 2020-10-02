/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
const shiftGrid = function (grid, k) {
  const flat = [];
  for (const row of grid) {
    flat.push(...row);
  }

  for (let i = 0; i < k % flat.length; i++) {
    flat.unshift(flat.pop());
  }

  const result = [];
  for (let i = 0; i < flat.length; i += grid[0].length) {
    result.push(flat.slice(i, i + grid[0].length));
  }
  return result;
};
