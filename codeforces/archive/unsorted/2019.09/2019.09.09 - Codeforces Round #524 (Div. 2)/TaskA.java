package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(); // friends
        int k = in.nextInt(); // sheets per notebook

        int redTotal = n * 2;
        int greenTotal = n * 5;
        int blueTotal = n * 8;

        out.print((int)(
            Math.ceil((double) redTotal / k) +
            Math.ceil((double) greenTotal / k) +
            Math.ceil((double) blueTotal / k)
        ));
    }
}
