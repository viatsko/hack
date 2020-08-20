package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();

    int[] h = new int[n];

    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      h[i] = in.nextInt();

      a[i] = in.nextInt();
    }

    int answer = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0  ; j < n; j++) {
        if (i != j && h[i] == a[j]) {
          answer++;
        }
      }
    }

    out.print(answer);
  }
}
