import java.util.Scanner;

public class PolynomialSign {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int positiveResult = 0;
        int negativeResult = 0;

        for (int i = 0; i < n + 1; i++) {
            long tmp = in.nextLong();

            if (positiveResult == 0) {
                positiveResult = tmp > 0 ? 1 : (tmp < 0 ? -1 : 0);
                negativeResult = positiveResult;

                if (i > 0 && i % 2 != 0) {
                    negativeResult = negativeResult * (-1);
                }
            } else if (tmp > 0) {
                if (positiveResult < 0) {
                    positiveResult = 1;
                }

                if (i % 2 != 0 && negativeResult > 0) {
                    negativeResult = -1;
                } else if (i % 2 == 0 && negativeResult < 0) {
                    negativeResult = 1;
                }
            } else if (tmp < 0) {
                if (positiveResult > 0) {
                    positiveResult = -1;
                }

                if (i % 2 != 0 && negativeResult < 0) {
                    negativeResult = 1;
                } else if (i % 2 == 0 && negativeResult > 0) {
                    negativeResult = -1;
                }
            }
        }

        System.out.println(positiveResult + " " + negativeResult);
    }
}
