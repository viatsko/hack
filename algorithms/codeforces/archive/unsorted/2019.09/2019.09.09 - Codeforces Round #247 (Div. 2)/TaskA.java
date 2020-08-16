package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] calories = new int[]{
            -1,
            in.nextInt(),
            in.nextInt(),
            in.nextInt(),
            in.nextInt()
        };

        String s = in.next();

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            answer += calories[s.charAt(i) - '0'];
        }

        out.print(answer);
    }
}
