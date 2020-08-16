import java.util.Scanner;

public class JavaStringsIntroduction {
    private static String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1, str.length());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a = in.next();
        String b = in.next();

        System.out.println(a.length() + b.length());
        System.out.println(a.compareTo(b) <= 0 ? "No" : "Yes");
        System.out.println(capitalize(a) + ' ' + capitalize(b));
    }
}
