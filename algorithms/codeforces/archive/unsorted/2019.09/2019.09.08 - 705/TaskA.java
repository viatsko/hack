package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                sb.append("I hate ");
            } else {
                sb.append("I love ");
            }

            if (i < n) {
                sb.append("that ");
            }
        }

        sb.append("it");

        out.print(sb.toString());
    }
}
