package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(); // a
        int b = in.nextInt(); // b
        int c = in.nextInt(); // ab

        long answer = 0;

        // ok first let's build obvious core
        answer += c * 2;

        // now let's see how many ab we can form a and b
        int pairs = Math.min(a, b);
        answer += pairs * 2;
        a -= pairs;
        b -= pairs;

        if (a > 0 || b > 0) {
            answer++;
        }

        out.print(answer);
    }
}
