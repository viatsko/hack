import java.util.Scanner;

public class RoyAndProfilePicture {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int l = in.nextInt();

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int w = in.nextInt();

            int h = in.nextInt();

            if (w < l || h < l) {
                System.out.println("UPLOAD ANOTHER");
            } else if (w >= l && h >= l && w == h) {
                System.out.println("ACCEPTED");
            } else {
                System.out.println("CROP IT");
            }
        }
    }
}
