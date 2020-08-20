import java.util.Scanner;

public class JavaSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += a[j];

                if (sum < 0) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
