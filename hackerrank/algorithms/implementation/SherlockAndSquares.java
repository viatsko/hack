import java.util.Scanner;

public class SherlockAndSquares {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            System.out.println((int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1));
        }
    }
}
