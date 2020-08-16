import java.util.Scanner;

public class SortingBubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int l = arr.length - 1;
        int swaps = 0;

        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;

            for (int i = 0; i < l; i++) {
                if (arr[i] > arr[i + 1]) {
                    arr[i] ^= arr[i + 1];
                    arr[i + 1] ^= arr[i];
                    arr[i] ^= arr[i + 1];

                    isSorted = false;

                    swaps++;
                }
            }

            l--;
        }

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[arr.length - 1]);
    }
}
