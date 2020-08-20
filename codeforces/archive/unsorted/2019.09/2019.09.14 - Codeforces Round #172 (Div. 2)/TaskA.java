package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    char[] str = in.next().toCharArray();
    str[0] = Character.toUpperCase(str[0]);
    out.print(str);
  }
}
