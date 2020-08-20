import java.util.Scanner;

public class FindProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long result = 1;

        for (int i = 0; i < n; i++) {
            result = (result * scanner.nextInt()) % 1000000007;
        }

        System.out.println(result);
    }
}
