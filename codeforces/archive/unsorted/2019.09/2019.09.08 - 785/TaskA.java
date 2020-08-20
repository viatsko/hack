package sources;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        Map<String, Integer> faces = new HashMap<String, Integer>(){{
           put("Tetrahedron", 4);
           put("Cube", 6);
           put("Octahedron", 8);
           put("Dodecahedron", 12);
           put("Icosahedron", 20);
        }};

        int n = in.nextInt();

        int answer = 0;

        while (n-- >= 0) {
            String line = in.nextLine();
            if (faces.containsKey(line))
                answer += faces.get(line);
        }

        out.print(answer);
    }
}
