/**
 * @param {number} R
 * @param {number} C
 * @param {number} r0
 * @param {number} c0
 * @return {number[][]}
 */
const allCellsDistOrder = function (R, C, r0, c0) {
  const result = new Array(R * C).fill(0);
  let resultIndex = 0;

  const visited = new Set();
  const q = [];
  q.push([r0, c0]);

  while (q.length) {
    const curr = q.shift();

    if (curr[0] < 0 || curr[1] < 0 || curr[0] >= R || curr[1] >= C) {
      continue;
    }

    const serializedStr = curr[0] + "," + curr[1];

    if (visited.has(serializedStr)) {
      continue;
    }

    visited.add(serializedStr);

    result[resultIndex++] = [curr[0], curr[1]];

    q.push([curr[0], curr[1] - 1]);
    q.push([curr[0] - 1, curr[1]]);
    q.push([curr[0], curr[1] + 1]);
    q.push([curr[0] + 1, curr[1]]);
  }

  return result;
};
