import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesRansomNote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int m = scanner.nextInt();

        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < n; i++) {
            words.compute(scanner.next(), (key, value) -> value == null ? 1 : value + 1);
        }

        for (int i = 0; i < m; i++) {
            String word = scanner.next();

            int count = words.getOrDefault(word, 0);

            if (count <= 0) {
                System.out.println("No");
                return;
            } else {
                words.put(word, count - 1);
            }
        }

        System.out.println("Yes");
    }
}
