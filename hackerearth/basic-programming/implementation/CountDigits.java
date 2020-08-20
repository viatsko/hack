import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.next();

        int[] n = new int[10];

        for (char ch : string.toCharArray()) {
            n[ch - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + n[i]);
        }
    }
}
