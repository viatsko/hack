import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        int fd = 0;
        int bd = 0;

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = in.nextInt();

                if (i == j) {
                    fd += tmp;
                }

                if (n - i - 1 == j) {
                    bd += tmp;
                }
            }
        }

        System.out.println(Math.abs(fd - bd));
    }
}
