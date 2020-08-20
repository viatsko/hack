import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
    private int calculate(int[] p1, int[] p2) {
        int d0 = p1[0] - p2[0];

        int d1 = p1[1] - p2[1];

        return d0 * d0 + d1 * d1;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(calculate(p1, p2));
        set.add(calculate(p1, p3));
        set.add(calculate(p1, p4));
        set.add(calculate(p2, p3));
        set.add(calculate(p2, p4));
        set.add(calculate(p3, p4));

        return !set.contains(0) && set.size() == 2;
    }
}
