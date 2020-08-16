package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    String s = in.nextLine();
    String t = in.nextLine();

    int sIndex = 0;

    for (int i = 0; i < t.length(); i++) {
      if (t.charAt(i) == s.charAt(sIndex)) {
        sIndex++;
      }
    }

    out.print(sIndex + 1);
  }
}
