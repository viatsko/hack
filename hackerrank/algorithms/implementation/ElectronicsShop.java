import java.util.Scanner;

public class ElectronicsShop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] keyboards = new int[n];
        for (int i = 0; i < n; i++) {
            keyboards[i] = in.nextInt();
        }

        int[] drives = new int[m];
        for (int i = 0; i < m; i++) {
            drives[i] = in.nextInt();
        }

        int result = 0;

        for (int keyboardPrice : keyboards) {
            for (int drivePrice : drives) {
                if ((result < keyboardPrice + drivePrice) && (keyboardPrice + drivePrice <= s)) {
                    result = keyboardPrice + drivePrice;
                }
            }
        }

        System.out.println(result > 0 ? result : -1);
    }
}
