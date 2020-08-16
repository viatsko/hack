import java.util.Scanner;

public class Staircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int empty = n - 1;
        int full = 1;

        char[] charArr = new char[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < empty; j++) {
                charArr[j] = ' ';
            }

            for (int j = 0; j < full; j++) {
                charArr[empty + j] = '#';
            }

            System.out.println(charArr);

            empty--;
            full++;
        }
    }
}
