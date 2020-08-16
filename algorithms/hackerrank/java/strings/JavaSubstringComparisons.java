import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaSubstringComparisons {
    private static String getSmallestAndLargest(String s, int k) {
        int n = s.length();

        String[] substrings = new String[n - k + 1];
        int si = 0;

        StringBuilder stringBuffer = new StringBuilder();

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        for (int i = 0; i < k; i++) {
            stringBuffer.append(s.charAt(i));
        }

        substrings[si++] = stringBuffer.toString();

        for (int i = k; i < n; i++) {
            stringBuffer.deleteCharAt(0);
            stringBuffer.append(s.charAt(i));
            substrings[si++] = stringBuffer.toString();
        }

        Arrays.sort(substrings);

        return substrings[0] + "\n" + substrings[n - k];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();

        int k = in.nextInt();

        in.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
