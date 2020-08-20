package sources;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        String rounds = in.next();

        int antonScore = 0;
        int danikScore = 0;

        for (int i = 0; i < n; i++) {
            if (rounds.charAt(i) == 'A') {
                antonScore++;
            } else {
                danikScore++;
            }
        }

        if (antonScore > danikScore) {
            out.print("Anton");
        } else if (danikScore > antonScore) {
            out.print("Danik");
        } else {
            out.print("Friendship");
        }
    }
}
