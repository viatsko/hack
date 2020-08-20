package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int d = in.nextInt();

        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(heights[i] - heights[j]) <= d) {
                    answer++;
                }
            }
        }

        out.print(answer * 2);
    }
}
