package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();

    int k = in.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        out.print(0);
        out.print(' ');
      }

      out.print(k);
      out.print(' ');

      for (int j = i + 1; j < n; j++) {
        out.print(0);
        out.print(' ');
      }

      out.print('\n');
    }
  }
}
