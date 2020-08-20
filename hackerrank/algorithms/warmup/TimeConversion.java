import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        int hour = Integer.valueOf(input.substring(0, 2));

        if (input.charAt(8) == 'P' && hour != 12) {
            hour += 12;
        } else if (input.charAt(8) == 'A' && hour == 12) {
            hour = 0;
        }

        System.out.println((hour >= 10 ? hour : "0" + hour) + input.substring(2, input.length() - 2));
    }
}
