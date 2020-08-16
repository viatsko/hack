package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        int answer = 0;

        while (a <= b) {
            a *= 3;
            b *= 2;
            answer++;
        }

        out.print(answer);
    }
}
