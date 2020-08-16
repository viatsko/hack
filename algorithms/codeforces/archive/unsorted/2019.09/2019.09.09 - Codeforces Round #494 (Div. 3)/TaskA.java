package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int pockets = 0;

        int[] coins = new int[101];

        while (n-- > 0) {
            int coin = in.nextInt();

            coins[coin]++;

            pockets = Math.max(pockets, coins[coin]);
        }

        out.print(pockets);
    }
}
