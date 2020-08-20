import java.util.Scanner;

public class TwoStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int[] chars = new int[26];

            String a = scanner.next();

            String b = scanner.next();

            int n = a.length();
            if (n != b.length()) {
                System.out.println("NO");
            } else {
                for (int j = 0; j < n; j++) {
                    chars[a.charAt(j) - 'a']++;
                    chars[b.charAt(j) - 'a']--;
                }

                boolean found = true;

                for (int j = 0; j < 26; j++) {
                    if (chars[j] != 0) {
                        System.out.println("NO");

                        found = false;

                        break;
                    }
                }

                if (found) {
                    System.out.println("YES");
                }
            }
        }
    }
}
