import java.util.Scanner;

public class SherlockAndTheBeast {
    private static void calculate(int x) {
        int m = x;

        while (m % 3 != 0) {
            m -= 5;

            if (m < 0) {
                System.out.println("-1");
                return;
            }
        }

        for (int j = 0; j < m; j++) {
            System.out.print("5");
        }

        for (int j = 0; j < (x - m); j++) {
            System.out.print("3");
        }

        System.out.print("\n");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int x = in.nextInt();

            calculate(x);
        }

        in.close();
    }
}
