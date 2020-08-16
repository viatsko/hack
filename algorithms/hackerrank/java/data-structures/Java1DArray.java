import java.util.Scanner;

public class Java1DArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        in.close();

        // Declare array a here
        int[] a = new int[n];

        for(int i = 0 ; i < n; i++){
            int val = in.nextInt();
            a[i] = val;
        }

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
