package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        String str = in.next();

        char[] chars = str.toCharArray();

        while (m-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            char c1 = in.next(".").charAt(0);
            char c2 = in.next(".").charAt(0);

            l--;

            for (int i = l; i < r; i++) {
                if (chars[i] == c1) {
                    chars[i] = c2;
                }
            }
        }

        out.println(chars);
    }
}
