import java.util.Scanner;

public class NQueens {
    private static boolean isAttacked(int x, int y, boolean[][] board, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i][y] && i != x) {
                return true;
            }

            if (board[x][i] && i != y) {
                return true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] && (i != x && j != y) && (i + j == x + y || i - j == x - y)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean backtrack(boolean[][] board, int current, int n) {
        if (current == n) {
            return true;
        }

        for (int j = 0; j < n; j++) {
            if (isAttacked(current, j, board, n)) {
                continue;
            }

            board[current][j] = true;

            if (backtrack(board, current + 1, n)) {
                return true;
            }

            board[current][j] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        boolean[][] arr = new boolean[n][n];

        if (backtrack(arr, 0, n)) {
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] ? "1 " : "0 ");
                }

                System.out.println();
            }
        } else {
            System.out.println("NO");
        }
    }
}
