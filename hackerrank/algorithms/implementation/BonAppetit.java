import java.util.Scanner;

public class BonAppetit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int total = 0;

        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();

            if (i == k) {
                continue;
            }

            total += tmp;
        }

        int overcharged = in.nextInt() - total / 2;

        System.out.println(overcharged > 0 ? overcharged : "Bon Appetit");
    }
}
