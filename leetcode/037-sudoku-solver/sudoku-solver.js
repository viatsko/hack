/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
const solveSudoku = function (board) {
  const squares = Array(3)
    .fill(null)
    .map(() =>
      Array(3)
        .fill(null)
        .map(() => new Set())
    );
  const cols = Array(9)
    .fill(null)
    .map(() => new Set());
  const rows = Array(9)
    .fill(null)
    .map(() => new Set());

  const getSquareSet = (i, j) => {
    return squares[Math.floor(i / 3)][Math.floor(j / 3)];
  };

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board.length; j++) {
      if (board[i][j] !== ".") {
        getSquareSet(i, j).add(board[i][j]);
        rows[i].add(board[i][j]);
        cols[j].add(board[i][j]);
      }
    }
  }

  const solve = (n) => {
    if (n === 81) {
      return true;
    }

    const x = Math.floor(n / 9);
    const y = Math.floor(n % 9);

    if (board[x][y] !== ".") {
      return solve(n + 1);
    } else {
      for (let i = 1; i <= 9; i++) {
        const val = `${i}`;
        if (getSquareSet(x, y).has(val) || rows[x].has(val) || cols[y].has(val))
          continue;

        getSquareSet(x, y).add(val);
        rows[x].add(val);
        cols[y].add(val);
        board[x][y] = val;

        if (solve(n + 1)) {
          return true;
        }

        getSquareSet(x, y).delete(val);
        rows[x].delete(val);
        cols[y].delete(val);
        board[x][y] = ".";
      }
    }

    return false;
  };

  solve(0);
};
