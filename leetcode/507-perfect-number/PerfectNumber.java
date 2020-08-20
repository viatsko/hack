import java.util.stream.IntStream;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        // from wikipedia https://en.wikipedia.org/wiki/Perfect_number
        int[] perfectNumbers = new int[]{6, 28, 496, 8128, 33550336};

        return IntStream.of(perfectNumbers).anyMatch(x -> x == num);
    }
}
