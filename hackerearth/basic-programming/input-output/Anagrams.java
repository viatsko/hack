import java.util.Scanner;

public class Anagrams {
    private static final int ALPHA_COUNT = 26;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int[] chars = new int[ALPHA_COUNT];

            String a = in.next();

            String b = in.next();

            int n = a.length();

            int m = b.length();

            for (int j = 0; j < n; j++) {
                chars[a.charAt(j) - 'a']++;
            }

            for (int j = 0; j < m; j++) {
                chars[b.charAt(j) - 'a']--;
            }

            int count = 0;

            for (int j = 0; j < ALPHA_COUNT; j++) {
                count += Math.abs(chars[j]);
            }

            System.out.println(count);
        }
    }
}
