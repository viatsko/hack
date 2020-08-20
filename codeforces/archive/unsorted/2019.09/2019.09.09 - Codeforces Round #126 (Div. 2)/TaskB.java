package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int orange = 0;
        int total = 0;

        while (n-- > 0) {
            orange += in.nextInt();
            total += 100;
        }

        out.format(String.valueOf((double)orange / total * 100));
    }
}
