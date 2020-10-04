151. Reverse Words in a String

Clarification:
What constitutes a word?
	A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
	Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
	Reduce them to a single space in the reversed string.


Solution：split + 倒序遍历append

public String reverseWords(String s) {
    String[] strs = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = strs.length - 1; i >= 0; i--) 
        if (!strs[i].equals(""))
            sb.append(strs[i]).append(" ");
    return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
}

此题不难，注意clarification里的细节，要去除头尾空格，单词中间多个空格reverse后只能有一个。




186. Reverse Words in a String II

public void reverseWords(char[] s) {
    reverse(s, 0, s.length - 1); // reverse the whole sentense
    int start = 0;
    for (int i = 0; i < s.length; i++) // reverse each word
        if (s[i] == ' ') {
            reverse(s, start, i - 1);
            start = i + 1;
        }
    reverse(s, start, s.length - 1); // reverse the last word
}
private void reverse(char[] s, int i, int j) {
    while (i < j) {
        char tmp = s[i];
        s[i++] = s[j];
        s[j--] = tmp;
    }
}