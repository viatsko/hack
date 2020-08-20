import java.util.Scanner;

public class AngryProfessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int count = 0;

            for (int i = 0; i < n; i++) {
                int tmp = in.nextInt();

                if (tmp <= 0) {
                    count++;
                }
            }

            System.out.println(count >= k ? "NO" : "YES");
        }

        in.close();
    }
}
