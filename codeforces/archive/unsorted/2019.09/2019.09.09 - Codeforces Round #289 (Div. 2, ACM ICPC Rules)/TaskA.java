package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            grid[i][0] = grid[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        out.print(grid[n - 1][n - 1]);
    }
}
