import java.util.Scanner;

public class CountingValleys {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int result = 0;

        int level = 0;

        int n = in.nextInt();

        String line = in.next();

        for (int i = 0; i < n; i++) {
            int before = level;

            if (line.charAt(i) == 'U') {
                level++;
            } else {
                level--;
            }

            if (level == 0 && before == -1) {
                result++;
            }
        }

        System.out.println(result);
    }
}
