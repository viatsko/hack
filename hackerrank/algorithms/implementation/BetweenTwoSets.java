import java.util.Scanner;

public class BetweenTwoSets {
    // gcd and lcm functions are from
    // https://stackoverflow.com/questions/4201860/how-to-find-gcd-lcm-on-a-set-of-numbers

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;

            b = a % b;

            a = temp;
        }

        return a;
    }

    private static int gcd(int[] input) {
        int result = input[0];

        for(int i = 1; i < input.length; i++) {
            result = gcd(result, input[i]);
        }

        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int lcm(int[] input) {
        int result = input[0];

        for(int i = 1; i < input.length; i++) {
            result = lcm(result, input[i]);
        }

        return result;
    }

    private static int getTotalX(int[] a, int[] b) {
        int count = 0;

        int lcm_a = lcm(a);
        int gcd_b = gcd(b);

        int current = lcm_a;

        while(current != gcd_b) {
            count += gcd_b % current == 0 ? 1 : 0;
            current += lcm_a;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];

        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] b = new int[m];

        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }

        int total = getTotalX(a, b);

        System.out.println(total);

        in.close();
    }
}
