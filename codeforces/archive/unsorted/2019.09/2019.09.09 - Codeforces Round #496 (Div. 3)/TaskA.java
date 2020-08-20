package sources;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();

    List<Integer> result = new LinkedList<>();

    int curLen = 0;

    while (n-- > 0) {
      int cur = in.nextInt();

      if (cur == 1) {
        if (curLen > 0) {
          result.add(curLen);
        }

        curLen = 1;
      } else {
        curLen++;
      }
    }

    if (curLen > 0) {
      result.add(curLen);
    }

    out.println(result.size());

    for (Integer size : result) {
      out.print(size + " ");
    }
  }
}
