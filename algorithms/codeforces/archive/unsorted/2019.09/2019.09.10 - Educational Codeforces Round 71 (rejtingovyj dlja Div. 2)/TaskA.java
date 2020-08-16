package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int t = in.nextInt();

    while (t-- > 0) {
      int b = in.nextInt() / 2;
      int p = in.nextInt();
      int f = in.nextInt();
      int h = in.nextInt();
      int c = in.nextInt();

      int first, second, firstPrice, secondPrice;

      if (h > c) {
        first = p;
        firstPrice = h;
        second = f;
        secondPrice = c;
      } else {
        first = f;
        firstPrice = c;
        second = p;
        secondPrice = h;
      }

      int sum = 0;

      int firstBurgers = Math.min(b, first);
      sum += firstBurgers * firstPrice;
      b -= firstBurgers;

      if (b > 0) {
        int secondBurgers = Math.min(b, second);
        sum += secondBurgers * secondPrice;
      }

      out.println(sum);
    }
  }
}
