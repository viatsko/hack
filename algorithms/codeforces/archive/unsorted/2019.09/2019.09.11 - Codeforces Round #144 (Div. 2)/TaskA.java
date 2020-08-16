package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();

    if ((n & 1) == 1) {
      out.print(-1);
    } else {
      for (int i = 1; i <= n; i += 2) {
        out.format("%d %d ", i + 1, i);
      }
    }
  }
}
