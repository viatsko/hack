
const countBattleships = board => {
    let count = 0;

    for (let row = 0; row < board.length; row++) {
        for (let col = 0; col < board[0].length; col++) {
            if (board[row][col] === 'X' &&
                (row === 0 || board[row - 1][col] !== 'X') &&
                (col === 0 || board[row][col - 1] !== 'X')
            ) {
                count++;
            }
        }
    }

    return count;
}
