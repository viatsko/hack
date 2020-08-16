package sources;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        if ((n & 1) == 1) {
            out.print(arr[n / 2]);
        } else {
            out.print(arr[(n - 1) / 2]);
        }
    }
}
