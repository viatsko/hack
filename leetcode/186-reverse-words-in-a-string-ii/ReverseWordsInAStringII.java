public class ReverseWordsInAStringII {
    private void reverseCharArray(char[] chars, int begin, int end) {
        while (begin < end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
    }

    public void reverseWords(char[] chars) {
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
    }
}
