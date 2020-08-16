package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String str = in.nextLine();

        int N = str.length();

        int lc = 0;

        for (int i = 0; i < N; i++) {
            char ch = str.charAt(i);
            if (ch == '4' || ch == '7') {
                lc++;
            }
        }

        out.print(lc == 4 || lc == 7 ? "YES": "NO");
    }
}
