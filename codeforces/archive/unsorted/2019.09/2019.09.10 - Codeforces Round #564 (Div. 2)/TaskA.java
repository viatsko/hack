package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        if (x > y) {
            x -= z;

            if (x <= y) {
                out.print('?');
            } else {
                out.print('+');
            }
        } else if (x == y) {
            x -= z;

            if (x != y) {
                out.print('?');
            } else {
                out.print('0');
            }
        } else {
            y -= z;

            if (x >= y) {
                out.print('?');
            } else {
                out.print('-');
            }
        }
    }
}
