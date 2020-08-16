package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();

        while (q-- > 0) {
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();

            out.println((a + b + c) / 2);
        }
    }
}
