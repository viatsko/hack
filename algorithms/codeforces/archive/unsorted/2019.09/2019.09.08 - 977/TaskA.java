package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();

        while (k-- > 0) {
            int lastDigit = n % 10;
            if (lastDigit == 0)
                n /= 10;
            else
                n--;
        }

        out.println(n);
    }
}
