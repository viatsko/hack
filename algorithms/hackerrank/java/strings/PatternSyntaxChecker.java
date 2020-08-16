import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternSyntaxChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        in.nextLine(); // because of nextInt -.-

        for (int i = 0; i < t; i++) {
            String pattern = in.nextLine();

            try {
                Pattern.compile(pattern);

                System.out.println("Valid");
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }
}
