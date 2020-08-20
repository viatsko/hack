import java.util.Scanner;

public class Java1DArrayII {
    public static boolean canWin(int index, int leap, int[] game) {
        if (index < 0 || game[index] == 1) { // game[index] == 1 means visited
            return false;
        } else if (index + 1 >= game.length || leap + index >= game.length) {
            return true;
        }

        game[index] = 1; // marking as visited

        return canWin(index + leap, leap, game) ||
               canWin(index + 1, leap, game) ||
               canWin(index - 1, leap, game);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int q = in.nextInt();

        while (q-- > 0) {
            int n = in.nextInt();

            int leap = in.nextInt();

            int[] game = new int[n];

            for (int i = 0; i < n; i++) {
                game[i] = in.nextInt();
            }

            System.out.println((canWin(0, leap, game)) ? "YES" : "NO");
        }

        in.close();
    }
}
