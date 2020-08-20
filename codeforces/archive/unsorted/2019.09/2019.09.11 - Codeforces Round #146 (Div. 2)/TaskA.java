package sources;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String nickname = in.nextLine();

        Set<Character> chars = new HashSet<>();

        for (int i = 0; i < nickname.length(); i++) {
            chars.add(nickname.charAt(i));
        }

        if ((chars.size() & 1) == 1) {
            out.print("IGNORE HIM!");
        } else {
            out.print("CHAT WITH HER!");
        }
    }
}
