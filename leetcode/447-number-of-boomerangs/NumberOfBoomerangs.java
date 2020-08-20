import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;

        int n = points.length;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                map.compute(dx * dx + dy * dy, (key, value) -> value == null ? 1 : value + 1);
            }

            for (int value : map.values()) {
                result += value * (value - 1);
            }
        }

        return result;
    }
}
