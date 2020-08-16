import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaAnagrams {
    private static boolean isAnagram(String a, String b) {
        int[] freq = new int[26];

        if (a.length() != b.length()) {
            return false;
        }

        int n = a.length();

        for (int i = 0; i < n; i++) {
            freq[Character.toLowerCase(a.charAt(i)) - 'a']++;
            freq[Character.toLowerCase(b.charAt(i)) - 'a']--;
        }

        for (int aFreq : freq) {
            if (aFreq != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String a = scan.next();

        String b = scan.next();

        scan.close();

        boolean ret = isAnagram(a, b);

        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
