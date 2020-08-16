package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        while (n-- > 0) {
            int num = in.nextInt();

            if ((num & 1) == 1) {
                out.print(num + " ");
            } else {
                out.print((num - 1) + " ");
            }
        }
    }
}
