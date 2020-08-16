import java.util.Scanner;

public class JavaLoopsII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int a = in.nextInt();

            int b = in.nextInt();

            int n = in.nextInt();

            int s = 0;

            for (int j = 0, pow = 1; j <= n; j++) {
                if (j == 0) {
                    s+= a;
                }

                if (j > 0) {
                    s += b * pow;

                    System.out.print(s + " ");

                    pow *= 2;
                }
            }

            System.out.println();
        }
    }
}
