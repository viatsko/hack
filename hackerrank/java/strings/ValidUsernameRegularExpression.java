import java.util.Scanner;

class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "^[A-Za-z][A-Za-z0-9_]{7,29}$";
}

public class ValidUsernameRegularExpression {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(in.nextLine());
        while (n-- != 0) {
            String userName = in.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
