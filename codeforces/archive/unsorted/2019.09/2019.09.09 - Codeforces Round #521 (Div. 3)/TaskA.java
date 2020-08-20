package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            long a = in.nextLong();
            long b = in.nextLong();
            long k = in.nextLong();

            long cnt = k / 2;

            if ((k & 1) == 1) {
                out.println(a * (cnt + 1) - b * cnt);
            } else {
                out.println((a - b) * cnt);
            }
        }
    }
}
