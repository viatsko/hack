package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int cur = in.nextInt();
            max = Math.max(cur, max);
            sum += cur;
        }

        out.print(max * n - sum);
    }
}
