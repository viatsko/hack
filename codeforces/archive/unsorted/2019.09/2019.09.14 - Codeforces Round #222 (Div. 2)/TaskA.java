package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int a = in.nextInt();

    int b = in.nextInt();

    int aw = 0;
    int tie = 0;
    int bw = 0;

    for (int i = 1; i <= 6; i++) {
      int ax = Math.abs(a - i);

      int bx = Math.abs(b - i);

      if (ax > bx) {
        bw++;
      } else if (ax < bx) {
        aw++;
      } else {
        tie++;
      }
    }

    out.format("%d %d %d", aw, tie, bw);
  }
}
