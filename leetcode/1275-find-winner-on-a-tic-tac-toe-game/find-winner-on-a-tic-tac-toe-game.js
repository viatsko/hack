const GRID_SIZE = 3;

/**
 * @param {number[][]} moves
 * @return {string}
 */
const tictactoe = function(moves) {
  const grid = new Array(GRID_SIZE).fill(0).map(row => new Array(GRID_SIZE).fill(''));

  let currentSign = 'X';
  for (const [i, j] of moves) {
    grid[i][j] = currentSign;
    currentSign = currentSign === 'X' ? 'O' : 'X';
  }
  return checkWinner(grid);
};

const checkWinner = function(grid) {
  const cols = new Array(GRID_SIZE).fill(0).map(el => ({'X': 0, 'O': 0}));
  const rows = new Array(GRID_SIZE).fill(0).map(el => ({'X': 0, 'O': 0}));
  const diag1 = {'X': 0, 'O': 0};
  const diag2 = {'X': 0, 'O': 0};

  let filled = 0;

  for (let i = 0; i < GRID_SIZE; i++) {
    for (let j = 0; j < GRID_SIZE; j++) {
      if (grid[i][j] !== '') {
        filled++;

        cols[j][grid[i][j]]++;

        if (cols[j][grid[i][j]] === 3) {
          return grid[i][j] === 'X' ? 'A' : 'B';
        }

        rows[i][grid[i][j]]++;

        if (rows[i][grid[i][j]] === 3) {
          return grid[i][j] === 'X' ? 'A' : 'B';
        }

        if (i === j) {
          diag1[grid[i][j]]++;

          if (diag1[grid[i][j]] === 3) {
            return grid[i][j] === 'X' ? 'A' : 'B';
          }
        }
        if (i === 3 - j - 1) {
          diag2[grid[i][j]]++;

          if (diag2[grid[i][j]] === 3) {
            return grid[i][j] === 'X' ? 'A' : 'B';
          }
        }
      }
    }
  }

  console.log(rows);
  console.log(grid);

  if (filled === 9) {
    return "Draw";
  } else {
    return "Pending";
  }
};
