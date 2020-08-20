package sources;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] sides = new int[]{ in.nextInt(), in.nextInt(), in.nextInt() };
        Arrays.sort(sides);
        out.println(Math.max(0, sides[2] - (sides[0] + sides[1] - 1)));
    }
}
