import java.util.HashSet;
import java.util.Set;

public class PossibleSums {
    int possibleSums(int[] coins, int[] quantity) {
        Set<Integer> sums = new HashSet<>();

        for (int i = 0; i < coins.length; i++) {
            Set<Integer> base = new HashSet<>();

            for (int j = 1; j <= quantity[i]; j++) {
                base.add(coins[i] * j);
            }

            Set<Integer> subSums = new HashSet<>();

            for (int num : sums) {
                for (int baseNum : base) {
                    subSums.add(num + baseNum);
                }
            }

            sums.addAll(base);
            sums.addAll(subSums);
        }

        return sums.size();
    }

}
