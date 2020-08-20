import java.util.Scanner;

public class BirthdayCakeCandles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int maxNumber = Integer.MIN_VALUE;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();

            if (tmp > maxNumber) {
                maxNumber = tmp;
                maxCount = 1;
            } else if (tmp == maxNumber) {
                maxCount++;
            }
        }

        System.out.println(maxCount);
    }
}
