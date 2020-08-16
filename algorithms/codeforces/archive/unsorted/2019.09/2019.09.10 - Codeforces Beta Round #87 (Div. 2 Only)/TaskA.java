package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int c = 0;
        int max = 0;

        while (n-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();

            c -= a - b;
            max = Math.max(c, max);
        }

        out.print(max);
    }
}
