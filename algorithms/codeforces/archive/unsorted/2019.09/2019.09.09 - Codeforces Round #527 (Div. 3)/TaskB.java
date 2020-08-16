package sources;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }

        Arrays.sort(scores);

        int answer = 0;
        for (int i = 0; i < n; i += 2) {
            answer += Math.abs(scores[i] - scores[i + 1]);
        }

        out.print(answer);
    }
}
