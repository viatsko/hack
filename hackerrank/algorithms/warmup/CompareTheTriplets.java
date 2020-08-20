import java.util.Scanner;

public class CompareTheTriplets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;

        int[] arr_a = new int[3];

        for (int i = 0; i < 3; i++) {
            arr_a[i] = in.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            int cur_b = in.nextInt();

            if (cur_b > arr_a[i]) {
                b++;
            } else if (cur_b < arr_a[i]) {
                a++;
            }
        }

        System.out.println(a + " " + b);
    }
}
