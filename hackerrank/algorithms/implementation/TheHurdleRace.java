import java.util.Scanner;

public class TheHurdleRace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, in.nextInt());
        }

        System.out.println(max > k ? max - k : 0);
    }
}
