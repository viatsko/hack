package sources;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int[][] students = new int[n][2];

        for (int i = 0; i < n; i++) {
            students[i][0] = i  + 1;
            students[i][1] = in.nextInt() + in.nextInt() + in.nextInt() + in.nextInt();
        }

        Arrays.sort(students, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < n; i++) {
            if (students[i][0] == 1) {
                out.print(i + 1);
                break;
            }
        }
    }
}
