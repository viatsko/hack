package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int h = in.nextInt();

        int answer = 0;

        while (n-- > 0) {
            if (in.nextInt() > h) {
                answer += 2;
            } else {
                answer++;
            }
        }

        out.print(answer);
    }
}
