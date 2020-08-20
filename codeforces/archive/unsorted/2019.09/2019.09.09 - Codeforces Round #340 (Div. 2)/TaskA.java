package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x = in.nextInt();

        out.print((int) Math.ceil((double) x / 5));
    }
}
