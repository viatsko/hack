package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        String str = in.next();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'x') {
                int len = 1;

                for (int j = i + 1; j < n && str.charAt(j) == 'x'; j++, i++, len++);

                if (len > 2) {
                    answer += len - 2;
                }
            }
        }

        out.print(answer);
    }
}
