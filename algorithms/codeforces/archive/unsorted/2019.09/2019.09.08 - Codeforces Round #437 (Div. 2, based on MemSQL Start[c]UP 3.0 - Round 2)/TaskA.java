package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int sToF = 0;
        int fToS = 0;

        char state = ' ';

        String line = in.next();

        for (char ch : line.toCharArray()) {
            if (state == 'S' && ch == 'F') {
                sToF++;
            } else if (state == 'F' && ch == 'S') {
                fToS++;
            }

            state = ch;
        }

        out.print(sToF > fToS ? "YES" : "NO");
    }
}
