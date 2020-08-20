package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        boolean isOdd = false;

        if (n < 2) {
            out.print(0);
        } else if (n <= 3) {
            out.println(1);
            out.print(n);
        } else {
            // odd
            if ((n & 1) == 1) {
                isOdd = true;
                n -= 3;
            }

            int half = n / 2;

            out.println(isOdd ? half + 1 : half);

            for (int i = 0; i < half; i++) {
                out.print('2');
                if (i < half - 1) {
                    out.print(' ');
                }
            }

            if (isOdd) {
                out.print(" 3");
            }
        }
    }
}
