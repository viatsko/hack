import java.util.Scanner;

public class AppleAndOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int apples = 0;
        int oranges = 0;

        int m = in.nextInt();
        int n = in.nextInt();

        for (int i = 0; i < m; i++) {
            int p = in.nextInt() + a;

            if (p >= s && p <= t) {
                apples++;
            }
        }

        for (int i = 0; i < n; i++) {
            int p = in.nextInt() + b;

            if (p >= s && p <= t) {
                oranges++;
            }
        }

        System.out.println(apples);
        System.out.println(oranges);
    }
}
