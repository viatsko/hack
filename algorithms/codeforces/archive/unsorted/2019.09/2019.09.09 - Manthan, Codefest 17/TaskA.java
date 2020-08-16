package sources;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        Set<String> seen = new HashSet<>();

        while (n-- > 0) {
            String name = in.next();

            if (!seen.contains(name)) {
                out.println("NO");
                seen.add(name);
            } else {
                out.println("YES");
            }
        }
    }
}
