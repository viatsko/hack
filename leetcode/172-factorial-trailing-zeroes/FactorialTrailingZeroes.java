public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;

        while (n > 0) {
            n /= 5;

            result += n;
        }

        return result;
    }
}
