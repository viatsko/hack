package sources;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        Set<Integer> used = new HashSet<>();

        int toBuy = 0;

        for (int i = 0; i < 4; i++) {
            int current = in.nextInt();

            if (!used.contains(current)) {
                used.add(current);
            } else {
                toBuy++;
            }
        }

        out.print(toBuy);
    }
}
