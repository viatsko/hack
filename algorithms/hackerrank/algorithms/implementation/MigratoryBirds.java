import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MigratoryBirds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int maxCount = Integer.MIN_VALUE;
        int maxValue = 0;

        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();

            Integer count = counts.get(tmp);

            count = count == null ? 1 : count + 1;

            if (count >= maxCount) {
                maxValue = count > maxCount ? tmp : Math.min(tmp, maxValue);
                maxCount = count;
            }

            counts.put(tmp, count);
        }

        System.out.println(maxValue);

        in.close();
    }
}
