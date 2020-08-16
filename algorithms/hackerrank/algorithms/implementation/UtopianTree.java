import java.util.Scanner;

public class UtopianTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int result = 1;

            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    result *= 2;
                } else {
                    result += 1;
                }
            }

            System.out.println(result);
        }

        in.close();
    }
}
