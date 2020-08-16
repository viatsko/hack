import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        Map<Character, String> numbers = new LinkedHashMap<>();
        numbers.put('0', "zero");
        numbers.put('2', "two");
        numbers.put('4', "four");
        numbers.put('6', "six");
        numbers.put('8', "eight");
        numbers.put('3', "three");
        numbers.put('5', "five");
        numbers.put('7', "seven");
        numbers.put('1', "one");
        numbers.put('9', "nine");

        int[] chars = new int[256];

        int n = s.length();
        for (int i = 0; i < n; i++) {
            chars[(int) s.charAt(i)]++;
        }

        Map<Character, Integer> result = new HashMap<>();

        for (Map.Entry<Character, String> number : numbers.entrySet()) {
            Map<Character, Integer> counts = new HashMap<>();

            String value = number.getValue();

            int m = value.length();

            for (int j = 0; j < m; j++) {
                char ch = value.charAt(j);

                counts.compute(ch, (key, val) -> val == null ? 1 : val + 1);
            }

            boolean hasSpace = true;
            while(hasSpace) {
                for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
                    if (chars[(int)entry.getKey()] < entry.getValue()) {
                        hasSpace = false;
                    }
                }

                if (hasSpace) {
                    for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
                        chars[(int)entry.getKey()] -= entry.getValue();
                    }

                    result.compute(number.getKey(), (key, val) -> val == null ? 1 : val + 1);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(entry.getKey());
            }
        }

        return stringBuilder.toString();
    }
}
