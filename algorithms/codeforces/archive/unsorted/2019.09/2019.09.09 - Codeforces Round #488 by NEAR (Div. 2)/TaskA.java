package sources;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = in.nextInt();
        }

        Set<Integer> fingerprints = new HashSet<>();
        for (int i = 0; i < m; i++) {
            fingerprints.add(in.nextInt());
        }

        for (int num : seq) {
            if (fingerprints.contains(num)) {
                out.print(num + " ");
            }
        }
    }
}
