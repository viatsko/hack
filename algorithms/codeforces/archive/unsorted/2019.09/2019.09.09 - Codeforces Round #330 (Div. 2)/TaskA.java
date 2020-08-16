package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int answer = 0;

        while (n-- > 0) {
            for (int i = 0; i < m; i++) {
                boolean light = false;

                for (int j = 0; j < 2; j++) {
                    if (in.nextInt() == 1 && !light) {
                        answer++;
                        light = true;
                    }
                }
            }
        }

        out.print(answer);
    }
}
