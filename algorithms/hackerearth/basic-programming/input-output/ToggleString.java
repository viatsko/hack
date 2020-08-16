import java.util.Scanner;

public class ToggleString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.next();

        char[] chars = string.toCharArray();

        int n = chars.length;
        for (int i = 0; i < n; i++) {
            chars[i] = Character.isLowerCase(chars[i]) ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]);
        }

        System.out.println(chars);
    }
}
