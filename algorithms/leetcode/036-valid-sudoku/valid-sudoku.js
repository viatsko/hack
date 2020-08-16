const isValidSudoku = board => {
    const rows = new Array(9).fill(0);
    const cols = new Array(9).fill(0);
    const groups = new Array(3).fill(0).map((el) => new Array(3).fill(0));

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            if (board[i][j] === '.') continue;

            const n = board[i][j];

            if (rows[i] & (1 << n)) {
                return false;
            } else {
                rows[i] |= (1<< n);
            }

            if (cols[j] & (1 << n)) {
                return false;
            } else {
                cols[j] |= (1<< n);
            }

            const gi = Math.floor(i / 3);
            const gj = Math.floor(j / 3);

            if (groups[gi][gj] & (1 << n)) {
                return false;
            } else {
                groups[gi][gj] |= (1 << n);
            }
        }
    }

    return true;
};
