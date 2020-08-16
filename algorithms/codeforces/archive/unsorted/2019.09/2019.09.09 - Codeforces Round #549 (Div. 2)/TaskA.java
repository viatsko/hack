package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int leftLast = n;
        int rightLast = n;

        for (int i = 1; i <= n; i++) {
            int cur = in.nextInt();
            if (cur == 1) {
                rightLast = i;
            } else {
                leftLast = i;
            }
        }

        out.print(Math.min(leftLast, rightLast));
    }
}
