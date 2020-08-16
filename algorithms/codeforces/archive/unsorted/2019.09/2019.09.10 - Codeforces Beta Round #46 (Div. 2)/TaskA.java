package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  private boolean isLetter(char ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
  }

  private boolean isVowel(char ch) {
    return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'Y' || ch == 'a'
        || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y';
  }

  public void solve(int testNumber, Scanner in, PrintWriter out) {
    String str = in.nextLine();

    int N = str.length();

    for (int i = N - 1; i >= 0; i--) {
      if (isLetter(str.charAt(i))) {
        if (isVowel(str.charAt(i))) {
          out.print("YES");
        } else {
          out.print("NO");
        }
        return;
      }
    }
  }
}
