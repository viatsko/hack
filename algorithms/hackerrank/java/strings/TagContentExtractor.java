import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        in.nextLine();

        Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");

        while (t-- > 0) {
            boolean isFound = false;

            String string = in.nextLine();

            Matcher matcher = pattern.matcher(string);

            while (matcher.find()) {
                System.out.println(matcher.group(2));

                isFound = true;
            }

            if (!isFound) {
                System.out.println("None");
            }
        }
    }
}
