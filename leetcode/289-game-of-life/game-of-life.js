const gameOfLife = board => {
    const countNeighbors = (row, col) => {
        let neighbors = 0;

        for (let i = Math.max(row - 1, 0); i <= Math.min(row + 1, board.length - 1); i++) {
            for (let j = Math.max(col - 1, 0); j <= Math.min(col + 1, board[0].length - 1); j++) {
                if (i === row && j === col) {
                    continue;
                }

                if (board[i][j] & 1) {
                    neighbors++;
                }
            }
        }

        return neighbors;
    };

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            const neighbors = countNeighbors(i, j);

            if (board[i][j] === 0 && neighbors === 3) {
                board[i][j] = 2; // 10
            } else if (board[i][j] === 1 && (neighbors === 2 || neighbors === 3)) {
                board[i][j] = 3;
            }
        }
    }

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            board[i][j] >>= 1;
        }
    }
};
