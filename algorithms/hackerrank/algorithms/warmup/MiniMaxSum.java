import java.util.Scanner;

public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long min = Long.MAX_VALUE;

        long max = Long.MIN_VALUE;

        long sum = 0;

        long tmp;
        while(in.hasNextLong()) {
            tmp = in.nextLong();

            if (tmp < min) {
                min = tmp;
            }

            if (tmp > max) {
                max = tmp;
            }

            sum += tmp;
        }

        System.out.println((sum - max) + " " + (sum - min));
    }
}
