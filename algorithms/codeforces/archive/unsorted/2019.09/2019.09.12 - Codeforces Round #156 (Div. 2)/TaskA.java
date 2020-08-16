package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();

    // chest, biceps, back
    int chest = 0;
    int biceps = 0;
    int back = 0;

    for (int i = 0; i < n; i++) {
      switch(i % 3) {
        case 0:
          chest += in.nextInt();
          break;
        case 1:
          biceps += in.nextInt();
          break;
        case 2:
          back += in.nextInt();
          break;
      }
    }

    if (chest > biceps && chest > back) {
      out.print("chest");
    } else if (biceps > back) {
      out.print("biceps");
    } else {
      out.print("back");
    }
  }
}
