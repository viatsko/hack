package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String t = in.next();

        boolean answer = false;

        while (in.hasNext()) {
            String card = in.next();

            if (card.length() == 2 && (t.charAt(0) == card.charAt(0) || t.charAt(1) == card.charAt(1))) {
                answer = true;
                break;
            }
        }

        out.print(answer ? "YES" : "NO");
    }
}
