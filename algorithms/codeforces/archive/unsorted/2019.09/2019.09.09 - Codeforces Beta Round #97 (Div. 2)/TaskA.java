package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++)
            arr[in.nextInt()] = i;

        for (int i = 1; i <= n; i++) {
            out.print(arr[i]);
            if (i < n) {
                out.print(' ');
            }
        }
    }
}
