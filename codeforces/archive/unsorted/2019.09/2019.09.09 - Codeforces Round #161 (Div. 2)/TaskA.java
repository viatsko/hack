package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    private final int MATRIX_SIZE = 5;

    private int scanMatrix(Scanner in) {
        int half = MATRIX_SIZE / 2;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (in.nextInt() == 1) {
                    return Math.abs(j - half) + Math.abs(i - half);
                }
            }
        }

        return 0;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.print(scanMatrix(in));
    }
}
