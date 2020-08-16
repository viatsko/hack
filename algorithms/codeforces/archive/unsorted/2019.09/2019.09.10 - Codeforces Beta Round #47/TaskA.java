package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int m = in.nextInt();
        int n = in.nextInt();

        // m rows, n cols
        out.print((m / 2 * n) + ((m & 1) == 1 ? n / 2 : 0));
    }
}
