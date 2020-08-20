package sources;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        boolean[] used = new boolean[m + 1];

        while (n-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();

            for (int i = l; i <= r; i++) {
                used[i] = true;
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            if (!used[i]) {
                result.add(i);
            }
        }

        out.println(result.size());
        for (Integer point : result) {
            out.print(point + " ");
        }
    }
}
