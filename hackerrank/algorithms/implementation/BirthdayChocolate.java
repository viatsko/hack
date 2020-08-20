import java.util.Scanner;

public class BirthdayChocolate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }

        int d = in.nextInt();
        int m = in.nextInt();

        int count = 0;

        for (int i = 0; i < n - m + 1; i++) {
            int total = s[i];

            for (int j = 0; j < m - 1; j++) {
                total += s[i + j + 1];
            }

            if (total == d) {
                count++;
            }
        }

        System.out.println(count);

        in.close();
    }
}
