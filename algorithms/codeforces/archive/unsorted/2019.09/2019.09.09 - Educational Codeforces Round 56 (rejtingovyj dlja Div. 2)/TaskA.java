package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        while (n-- > 0) {
            out.println(in.nextInt() / 2);
        }
    }
}
