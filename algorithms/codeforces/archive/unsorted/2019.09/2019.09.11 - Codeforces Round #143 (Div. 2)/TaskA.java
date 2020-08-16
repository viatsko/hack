package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int answer = 0;

        while (n-- > 0) {
            int sure = 0;

            for (int i = 0; i < 3; i++) {
                sure += in.nextInt();
            }

            if (sure >= 2) {
                answer++;
            }
        }

        out.print(answer);
    }
}
