package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    static class Stats {
        int received = 0;
        int lost = 0;
    }

    private final int N_SERVERS = 2;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        Stats[] stats = new Stats[N_SERVERS + 1];

        for (int i = 1; i <= N_SERVERS; i++) {
            stats[i] = new Stats();
        }

        while (n-- > 0) {
            int t = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            stats[t].received += x;
            stats[t].lost += y;
        }

        for (int i = 1; i <= N_SERVERS; i++) {
            if (stats[i].received >= stats[i].lost) {
                out.println("LIVE");
            } else {
                out.println("DEAD");
            }
        }
    }
}
