import java.util.Scanner;

public class BeautifulDaysAtTheMovies {
    private static int reverseNumber(int n) {
        int reverse = 0;

        while (n > 0) {
            reverse = reverse * 10;
            reverse = reverse + n % 10;
            n = n / 10;
        }

        return reverse;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();

        int result = 0;

        for (int d = i; d <= j; d++) {
            if (d % k == 0 && reverseNumber(d) % k == 0) {
                result++;
            }
        }

        System.out.println(result);
    }
}
