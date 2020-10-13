/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
const exist = function(board, word) {
  const dirs = [[0, -1], [-1, 0], [0, 1], [1, 0]];

  const helper = (i, j, index) => {
      const ch = board[i][j];

      if (ch !== word[index]) return false;
      if (ch === word[index] && index === (word.length - 1)) return true;

      board[i][j] = '#';

      for (const dir of dirs) {
          const x = i + dir[0];
          const y = j + dir[1];

          if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] !== '#') {
              if (helper(x, y, index + 1)) {
                  return true;
              }
          }
      }

      board[i][j] = ch;

      return false;
  }

  for (let i = 0; i < board.length; i++) {
      for (let j = 0; j < board[0].length; j++) {
          if (helper(i, j, 0)) {
              return true;
          }
      }
  }

  return false;
};
