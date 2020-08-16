public class ReverseWordsInAString {
    private String trimString(String s) {
        int n = s.length();
        int i = 0; // orig
        int j = 0; // out
        char[] chars = new char[n];
        while(i < n) {
            while (i < n && s.charAt(i) == ' ') i++;
            while (i < n && s.charAt(i) != ' ') chars[j++] = s.charAt(i++);
            while (i < n && s.charAt(i) == ' ') i++;
            if (i < n) {
                chars[j++] = ' ';
            }
        }

        return new String(chars).substring(0, j);
    }

    private void reverseCharArray(char[] chars, int begin, int end) {
        while (begin < end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
    }

    public String reverseWords(String s) {
        char[] chars = trimString(s).toCharArray();

        int n = chars.length;

        reverseCharArray(chars, 0, n - 1);

        int i = 0;
        while (i < n) {
            while (i < n && chars[i] == ' ') i++;

            int j = i;

            while (j < n && chars[j] != ' ') j++;

            reverseCharArray(chars, i, j - 1);

            i = j;
        }

        return new String(chars);
    }
}
