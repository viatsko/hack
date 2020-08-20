package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();

    String s = in.next();

    int answer = 0;

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);

      int len = 0;

      while (i < (n - 1) && s.charAt(i + 1) == ch) {
        len++;
        i++;
      }

      answer += len;
    }

    out.print(answer);
  }
}
