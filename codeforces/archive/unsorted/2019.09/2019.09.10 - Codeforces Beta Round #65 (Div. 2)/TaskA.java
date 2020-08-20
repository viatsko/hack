package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        while (n-- > 0) {
            String word = in.next();

            int wordLength = word.length();

            if (wordLength <= 10) {
                out.println(word);
            } else {
                out.println("" + word.charAt(0) + (wordLength - 2) + word.charAt(wordLength - 1));
            }
        }
    }
}
