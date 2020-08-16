package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int c = in.nextInt();

        int[] p = new int[n];
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }

        int l = 0;
        int r = 0;

        int lTime = 0;
        int rTime = 0;

        for (int i = 0; i < n; i++) {
            lTime += t[i];
            rTime += t[n - i - 1];

            l += Math.max(0, p[i] - c * lTime);
            r += Math.max(0, p[n - i - 1] - c * rTime);
        }

        if (l > r) {
            out.print("Limak");
        } else if (r > l) {
            out.print("Radewoosh");
        } else {
            out.print("Tie");
        }
    }
}
