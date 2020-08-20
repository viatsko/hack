import java.util.Scanner;

public class FindDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int nc = n;
            int c = 0;

            while(nc != 0) {
                int d = nc % 10;

                if (d != 0 && n % d == 0) {
                    c++;
                }

                nc /= 10;
            }

            System.out.println(c);
        }

        in.close();
    }
}
