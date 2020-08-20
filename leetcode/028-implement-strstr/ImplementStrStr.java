public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        for (int i = 0; i < h - n + 1; i++) {
            int j;

            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == n) {
                return i;
            }
        }

        return -1;
    }
}
