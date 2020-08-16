package sources;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = in.next();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);

                if (ch == '*') {
                    if (xSet.contains(i)) {
                        xSet.remove(i);
                    } else {
                        xSet.add(i);
                    }

                    if (ySet.contains(j)) {
                        ySet.remove(j);
                    } else {
                        ySet.add(j);
                    }
                }
            }
        }

//        System.out.println(xSet.toString());
//        System.out.println(ySet.toString());

        out.print(((Integer) xSet.toArray()[0] + 1) + " " + ((Integer) ySet.toArray()[0] + 1));
    }
}
