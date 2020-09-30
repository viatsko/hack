/**
 * @param {number[][]} board
 * @return {number[][]}
 */
const candyCrush = function (board) {
  const R = board.length;
  const C = board[0].length;

  let todo;

  do {
    todo = false;

    for (let c = 0; c < C; c++) {
      for (let r = 0; r + 2 < R; r++) {
        if (
          board[r][c] !== 0 &&
          Math.abs(board[r][c]) === Math.abs(board[r + 1][c]) &&
          Math.abs(board[r][c]) === Math.abs(board[r + 2][c])
        ) {
          board[r][c] = board[r + 1][c] = board[r + 2][c] =
            -1 * Math.abs(board[r][c]);
          todo = true;
        }
      }
    }

    for (let c = 0; c + 2 < C; c++) {
      for (let r = 0; r < R; r++) {
        if (
          board[r][c] !== 0 &&
          Math.abs(board[r][c]) === Math.abs(board[r][c + 1]) &&
          Math.abs(board[r][c]) === Math.abs(board[r][c + 2])
        ) {
          board[r][c] = board[r][c + 1] = board[r][c + 2] =
            -1 * Math.abs(board[r][c]);
          todo = true;
        }
      }
    }

    for (let c = 0; c < C; c++) {
      let cr = R - 1;

      for (let r = R - 1; r >= 0; r--) {
        if (board[r][c] > 0) {
          board[cr][c] = board[r][c];
          cr--;
        }
      }

      while (cr >= 0) {
        board[cr--][c] = 0;
      }
    }
    // console.log(board);
    // break;
  } while (todo);

  return board;
};
