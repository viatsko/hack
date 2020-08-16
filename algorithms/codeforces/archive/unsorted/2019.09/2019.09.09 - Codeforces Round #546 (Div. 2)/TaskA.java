package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int[][] chapters = new int[n][2];

        for (int i = 0; i < n; i++) {
            chapters[i][0] = in.nextInt();
            chapters[i][1] = in.nextInt();
        }

        int k = in.nextInt();
        int done = 0;
        for (int i = 0; i < n; i++) {
            if (k <= chapters[i][1]) {
                break;
            }

            done++;
        }

        out.print(n - done);
    }
}
