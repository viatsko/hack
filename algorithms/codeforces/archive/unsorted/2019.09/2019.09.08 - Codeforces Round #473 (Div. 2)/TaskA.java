package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        if ((n & 1) == 1) {
            out.print("Ehab");
        } else {
            out.print("Mahmoud");
        }
    }
}
