public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int a = 0;

        int b = (int) Math.sqrt(c);

        while (a <= b) {
            int sum = a*a + b*b;

            if (sum < c) {
                a++;
            } else if (sum > c) {
                b--;
            } else {
                return true;
            }
        }

        return false;
    }
}
