package sources;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    private final int N = 4;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] sums = new int[N];

        int i = 0;
        while (i < N)
            sums[i++] = in.nextInt();

        Arrays.sort(sums);

        out.format("%d %d %d", sums[N - 1] - sums[0], sums[N - 1] - sums[1], sums[N - 1] - sums[2]);
    }
}
