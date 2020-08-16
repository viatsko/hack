import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        while (in.hasNext()) {
            Stack<Character> stack = new Stack<>();

            boolean isValid = true;

            String string = in.next();

            for (int i = 0; i < string.length(); i++) {
                Character ch = string.charAt(i);

                if (map.get(ch) != null) {
                    stack.push(ch);
                } else if (stack.isEmpty()) {
                    isValid = false;
                } else {
                    Character popped = map.get(stack.pop());

                    if (popped == null || !popped.equals(ch)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (stack.size() > 0) {
                isValid = false;
            }

            System.out.println(isValid);
        }
    }
}
