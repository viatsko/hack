import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaStringTokens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.nextLine();

        List<String> tokens = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                stringBuilder.append(ch);
            } else {
                if (stringBuilder.length() > 0) {
                    tokens.add(stringBuilder.toString());

                    stringBuilder.setLength(0);
                }
            }
        }

        if (stringBuilder.length() > 0) {
            tokens.add(stringBuilder.toString());
        }

        System.out.println(tokens.size());

        for (String token : tokens) {
            System.out.println(token);
        }

        in.close();
    }
}
