package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        String str = in.next();

        int skip = 0;
        for (int i = 0; i < n; i += skip) {
            out.print(str.charAt(i));
            skip++;
        }
    }
}
