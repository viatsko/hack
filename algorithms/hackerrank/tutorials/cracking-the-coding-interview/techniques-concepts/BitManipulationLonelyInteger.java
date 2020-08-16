import java.util.Scanner;

public class BitManipulationLonelyInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int result = 0;

        for (int i = 0; i < n; i++) {
            result ^= scanner.nextInt();
        }

        System.out.println(result);
    }
}
