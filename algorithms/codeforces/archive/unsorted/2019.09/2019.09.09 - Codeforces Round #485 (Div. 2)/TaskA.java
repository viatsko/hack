package sources;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        Map<String, String> stones = new HashMap<String, String>(){{
            put("purple", "Power");
            put("green", "Time");
            put("blue", "Space");
            put("orange", "Soul");
            put("red", "Reality");
            put("yellow", "Mind");
        }};

        int n = in.nextInt();

        while (n-- > 0) {
            stones.remove(in.next());
        }

        Collection<String> stonesNames = stones.values();

        out.println(stonesNames.size());

        for (String stone : stones.values()) {
            out.println(stone);
        }
    }
}
