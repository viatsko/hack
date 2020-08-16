package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int answer = 0;

        for (int i = 1; i <= n / 2; i++) {
            int e = n - i;

            if (e % i == 0) {
                answer++;
            }
        }

        out.print(answer);
    }
}
