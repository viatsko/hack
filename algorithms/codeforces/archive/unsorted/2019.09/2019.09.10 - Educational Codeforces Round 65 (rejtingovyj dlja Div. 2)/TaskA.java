package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();

            String str = in.next();

            boolean isPossible = false;

            for (int i = 0; i < n && n - i >= 11; i++) {
                if (str.charAt(i) == '8') {
                    isPossible = true;
                    break;
                }
            }

            out.println(isPossible ? "YES" : "NO");
        }
    }
}
