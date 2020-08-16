package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] seqs = new int[]{100, 20, 10, 5, 1};

        int n = in.nextInt();

        int count = 0;

        for (int i = 0; i < seqs.length; i++) {
            count += n / seqs[i];
            n %= seqs[i];
        }

        out.print(count);
    }
}
