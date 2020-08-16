package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    private char hpToCategory(int hp) {
        switch (hp % 4) {
            case 1:
                return 'A';
            case 2:
                return 'C';
            case 3:
                return 'B';
            case 0:
                return 'D';
        }

        return '0';
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x = in.nextInt();

        int diff = 0;
        char category = hpToCategory(x);

        for (int i = 1; i <= 2; i++) {
            char categoryToCheck = hpToCategory(x + i);

            if (categoryToCheck < category) {
                category = categoryToCheck;
                diff = i;
            }
        }

        out.print(diff + " " + category);
    }
}
