import java.util.Scanner;

public class JavaSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.next();

        int start = in.nextInt();
        int end = in.nextInt();

        System.out.println(string.substring(start, end));
    }
}
