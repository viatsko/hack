package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        String str = in.next();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (((str.charAt(i) - '0') & 1) == 0) {
                answer += (i + 1);
            }
        }

        out.print(answer);
    }
}
