package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int Tn = 0;
        for (int i = 1; i <= n; i++) {
            Tn = i * (i + 1) / 2;
            if (Tn == n) {
                out.print("YES");
                return;
            }
        }

        out.print("NO");
    }
}
