import java.util.*;

public class DivisibleSumPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] mods = new int[k];

        int total = 0;

        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();

            int mod = tmp % k;

            total += mods[(k - mod) % k];

            mods[mod]++;
        }

        System.out.println(total);

        in.close();
    }
}
