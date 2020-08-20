package sources;

import java.util.*;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        String str = in.next();
        int N = str.length();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'B') {
                int len = 1;
                i++;

                while (i < N && str.charAt(i) == 'B') {
                    len++;
                    i++;
                }

                result.add(len);
            }
        }

        int rs = result.size();
        out.println(rs);
        for (int i = 0; i < rs; i++) {
            out.print(result.get(i));
            if (i < rs - 1) {
                out.print(' ');
            }
        }
    }
}
