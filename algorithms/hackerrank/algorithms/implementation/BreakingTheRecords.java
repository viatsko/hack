import java.util.Scanner;

public class BreakingTheRecords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int min = in.nextInt();
        int max = min;

        int min_count = 0;
        int max_count = 0;

        for (int i = 1; i < n; i++) {
            int tmp = in.nextInt();

            if (tmp < min) {
                min_count++;
                min = tmp;
            }

            if (tmp > max) {
                max_count++;
                max = tmp;
            }
        }

        System.out.println(max_count + " " + min_count);

        in.close();
    }
}
