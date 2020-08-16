package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int s = in.nextInt();
        int v1 = in.nextInt();
        int v2 = in.nextInt();
        int t1 = in.nextInt();
        int t2 = in.nextInt();

        int firstScore = 2 * t1 + v1 * s;
        int secondScore = 2 * t2 + v2 * s;

        if (firstScore < secondScore) {
            out.print("First");
        } else if (secondScore < firstScore) {
            out.print("Second");
        } else {
            out.print("Friendship");
        }
    }
}
