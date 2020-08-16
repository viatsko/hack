public class DesignTicTacToe {
    class TicTacToe {
        private int size;
        private int[] rows;
        private int[] cols;
        private int diagonal = 0;
        private int backDiagonal = 0;

        /** Initialize your data structure here. */
        public TicTacToe(int size) {
            this.size = size;

            this.rows = new int[size];
            this.cols = new int[size];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int val = player == 1 ? -1 : 1;

            this.rows[row] += val;

            this.cols[col] += val;

            if (row == col) {
                this.diagonal += val;
            }

            if (row == (size - col - 1)) {
                this.backDiagonal += val;
            }

            if (
                    Math.abs(this.rows[row]) == size ||
                            Math.abs(this.cols[col]) == size ||
                            Math.abs(this.diagonal) == size ||
                            Math.abs(this.backDiagonal) == size
                    ) {
                return player;
            }

            return 0;
        }
    }

    /*
     * Your TicTacToe object will be instantiated and called as such:
     * TicTacToe obj = new TicTacToe(n);
     * int param_1 = obj.move(row,col,player);
     */
}
