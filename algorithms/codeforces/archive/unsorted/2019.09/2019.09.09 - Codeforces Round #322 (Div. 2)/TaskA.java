package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        int min = Math.min(a, b);

        a -= min;
        b -= min;

        out.format("%d %d", min, a / 2 + b / 2);
    }
}
