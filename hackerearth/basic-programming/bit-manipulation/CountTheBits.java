import java.util.Scanner;

public class CountTheBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int count = 0;

            while (n != 0) {
                if ((n & 1) != 0) {
                    count++;
                }

                n >>= 1;
            }

            System.out.println(count);
        }
    }
}
