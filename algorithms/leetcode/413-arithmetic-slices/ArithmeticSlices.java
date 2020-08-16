public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int current = 0;
        int result = 0;

        /*
         * minimum arithmetic slice length is 3
         * and we know that A[i] - A[i - 1] == A[i - 1] - A[i - 2]
         * (the difference between any two consecutive elements is the same)
         */
        for (int i = 2; i < A.length; i++) {
            if (A[i - 2] - A[i - 1] == A[i - 1] - A[i]) {
                current += 1;
                result += current;
            } else {
                current = 0;
            }
        }

        return result;
    }
}
