package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int w = in.nextInt();
        int h = in.nextInt();
        int k = in.nextInt();

        int answer = 0;

        while (k-- > 0 && w > 0 && h > 0) {
            if (w == 1 || h == 1) {
                answer += w * h;
                break;
            } else {
                answer += 2 * (w - 2) + 2 * h;

                w -= 4;
                h -= 4;
            }
        }

        out.print(answer);
    }
}
