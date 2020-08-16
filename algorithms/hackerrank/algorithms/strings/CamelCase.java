import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        String string = new Scanner(System.in).next();

        if (string.length() == 0) {
            System.out.println(0);
        } else {
            int result = 1;

            for (int i = 0; i < string.length(); i++) {
                if (Character.isUpperCase(string.charAt(i))) {
                    result++;
                }
            }

            System.out.println(result);
        }
    }
}
