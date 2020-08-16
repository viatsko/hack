package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int i = 1;
        for (;;) {
            if (m < i) {
                out.print(m);
                return;
            }
            m -= i;
            if (i == n) {
                i = 1;
            } else {
                i++;
            }
        }
    }
}
