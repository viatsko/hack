package me.viatsko.leetcode.SudokuSolver;

import java.util.Arrays;

class Solution {
    private boolean[] checkFree(char[][] board, int x, int y) {
        boolean[] free = new boolean[9];

        Arrays.fill(free, true);

        for (int i = 0; i < 9; i++) {
            if (board[i][y] != '.') {
                free[board[i][y] - '1'] = false;
            }

            if (board[x][i] != '.') {
                free[board[x][i] - '1'] = false;
            }
        }

        int row = x / 3;
        int col = y / 3;

        for (int i = row * 3; i < (row + 1) * 3; i++) {
            for (int j = col * 3; j < (col + 1) * 3; j++) {
                if (board[i][j] != '.') {
                    free[board[i][j] - '1'] = false;
                }
            }
        }

        return free;
    }

    private boolean dfs(char[][] board, int n) {
        if (n == 81) {
            return true;
        }

        int i = n / 9;
        int j = n % 9;

        if (board[i][j] != '.') {
            return dfs(board, n + 1);
        }

        boolean[] free = checkFree(board, i, j);

        for (int num = 1; num <= 9; num++) {
            if (free[num - 1]) {
                board[i][j] = (char) (num + '0');

                printMatrix(board);

                if (dfs(board, n + 1)) {
                    return true;
                }
            }
        }

        board[i][j] = '.';

        return false;
    }

    public void printMatrix(char[][] board) {
        System.out.println("- - - - - - - - - ");
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
        System.out.println("- - - - - - - - - ");
    }

    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }
}

public class Main {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution solution = new Solution();

        solution.solveSudoku(board);
        solution.printMatrix(board);
    }
}
