package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA1 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        int answer = 0;

        int half = n / 2;
        for (int i = 0; i < n; i++) {
            if (i == half) {
                answer += grid[half][half];
            } else {
                answer += grid[half][i] + grid[i][half] + grid[i][i] + grid[i][n - i - 1];
            }
        }

        out.print(answer);
    }
}
