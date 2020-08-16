package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();

        int N = s.length();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        out.print(Math.min(count * 2 - 1, N));
    }
}
