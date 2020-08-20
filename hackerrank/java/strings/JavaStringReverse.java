import java.util.Scanner;

public class JavaStringReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.next();

        int i = 0;
        int j = string.length() - 1;

        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                System.out.println("No");
                return;
            }

            i++;
            j--;
        }

        System.out.println("Yes");
    }
}
