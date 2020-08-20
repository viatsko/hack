package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        boolean isReplaced = false;

        StringBuilder sb = new StringBuilder();

        while(n-- > 0) {
            char[] seats = in.next().toCharArray();

            if (!isReplaced && seats[0] == 'O' && seats[1] == 'O') {
                isReplaced = true;
                seats[0] = '+';
                seats[1] = '+';
            } else if (!isReplaced && seats[3] == 'O' && seats[4] == 'O') {
                isReplaced = true;
                seats[3] = '+';
                seats[4] = '+';
            }

            sb.append(seats);
            sb.append('\n');
        }

        if (isReplaced) {
            out.println("YES");
            out.print(sb.toString());
        } else {
            out.print("NO");
        }
    }
}
