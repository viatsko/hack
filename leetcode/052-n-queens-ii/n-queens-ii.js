/**
 * @param {number} n
 * @return {number}
 */
const totalNQueens = function (n) {
  const v = new Set();
  const d1 = new Set();
  const d2 = new Set();

  let result = 0;

  const helper = function (row) {
    if (row === n) {
      result++;
      return;
    }

    for (let i = 0; i < n; i++) {
      if (v.has(i) || d1.has(i + row) || d2.has(i - row)) {
        continue;
      }

      v.add(i);
      d1.add(i + row);
      d2.add(i - row);

      helper(row + 1);

      v.delete(i);
      d1.delete(i + row);
      d2.delete(i - row);
    }
  };

  helper(0);

  return result;
};
