import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numbers = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

        if (numbers[0].equals("0")) { // for [0, 0] input
            return "0";
        }

        return String.join("", numbers);
    }
}
