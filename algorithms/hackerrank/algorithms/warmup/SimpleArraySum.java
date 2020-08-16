import java.util.Scanner;

public class SimpleArraySum {
    private static int simpleArraySum(int n, int[] ar) {
        int result  = 0;

        for (int i = 0; i < n; i++) {
            result += ar[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = simpleArraySum(n, ar);
        System.out.println(result);
    }
}
