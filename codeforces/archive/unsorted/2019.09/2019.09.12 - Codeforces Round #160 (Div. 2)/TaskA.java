package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();

    int k = in.nextInt();

    int answer = 0;

    for (int i = 0; i < n; i++) {
      int luckyCount = 0;

      int num = in.nextInt();

      while (num != 0) {
        int right = num % 10;

        if (right == 4 || right == 7) {
          luckyCount++;
        }

        num /= 10;
      }

      if (luckyCount <= k) {
        answer++;
      }
    }

    out.print(answer);
  }
}
