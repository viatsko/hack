import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StacksBalancedBrackets {
    public static void main(String[] args) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String string = scanner.next();

            boolean valid = true;

            Stack<Character> stack = new Stack<>();

            int n = string.length();

            for (int j = 0; j < n; j++) {
                char ch = string.charAt(j);

                if (map.get(ch) != null) {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }

                    char bch = stack.pop();

                    if (!map.get(bch).equals(ch)) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                valid = false;
            }

            System.out.println(valid ? "YES" : "NO");
        }
    }
}
