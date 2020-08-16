import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SockMerchant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int result = 0;

        Set<Integer> set = new HashSet<>();

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();

            if (set.contains(tmp)) {
                set.remove(tmp);
                result++;
            } else {
                set.add(tmp);
            }
        }

        System.out.println(result);
    }
}
