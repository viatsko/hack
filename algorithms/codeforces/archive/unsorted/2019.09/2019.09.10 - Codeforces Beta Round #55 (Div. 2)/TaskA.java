package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String str = in.nextLine();

        int lower = 0;
        int upper = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                lower++;
            } else {
                upper++;
            }
        }

        if (lower >= upper) {
            out.print(str.toLowerCase());
        } else {
            out.print(str.toUpperCase());
        }
    }
}
