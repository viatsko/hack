import java.util.Scanner;

public class CardGames {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);

        int na = in.nextInt();

        /*
         * Reading all cards of player A to an array
         * for later processing
         */
        int[] arr = new int[na];

        for (int i = 0; i < na; i++) {
            arr[i] = in.nextInt();
        }

        /*
         * Searching for the max card of player B
         */
        int max = 0;

        int nb = in.nextInt();

        for (int i = 0; i < nb; i++) {
            max = Math.max(max, in.nextInt());
        }

        // we need to increment it by 1 because we want to always win
        max++;

        /*
         * Now we are walking through player A cards and if one of them is not winning,
         * we are simply calculating the difference and adding it to result
         */
        long result = 0;

        for (int i = 0; i < na; i++) {
            if (arr[i] < max) {
                result += max - arr[i];
            }
        }

        System.out.println(result);
    }
}
