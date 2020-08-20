package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int mishkaScore = 0;
        int chrisScore = 0;

        while (n-- > 0) {
            int m = in.nextInt();
            int c = in.nextInt();

            if (m > c) {
                mishkaScore++;
            } else if (m < c) {
                chrisScore++;
            }
        }

        if (mishkaScore > chrisScore) {
            out.print("Mishka");
        } else if (mishkaScore < chrisScore) {
            out.print("Chris");
        } else {
            out.print("Friendship is magic!^^");
        }
    }
}
