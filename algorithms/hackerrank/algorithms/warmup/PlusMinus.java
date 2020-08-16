import java.util.Scanner;

public class PlusMinus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int negative = 0;
        int positive = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();

            if (tmp > 0) {
                positive++;
            } else if (tmp < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        System.out.format("%.6f\n", (double) positive / n);
        System.out.format("%.6f\n", (double) negative / n);
        System.out.format("%.6f\n", (double) zero / n);
    }
}
