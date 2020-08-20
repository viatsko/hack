package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        String state = "";

        int answer = 0;

        while (n-- > 0) {
            String cur = in.next();

            if (!state.equals(cur)) {
                answer++;

                state = cur;
            }
        }

        out.print(answer);
    }
}
