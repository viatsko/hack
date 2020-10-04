Count Palindromic Substrings
找一个字符串所有回文子字符串的个数

public static int longestPalindrome(String s) {
    int start = 0, end = 0, res = 0;
    for (int i = 0; i < s.length(); i++) 
        res += countExpandPalindromes(s, i, i);
    for (int i = 0; i < s.length() - 1; i++) 
        res += countExpandPalindromes(s, i, i + 1);
    return res;
}
private static int countExpandPalindromes(String s, int i, int j) {
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
        i--;
        j++;
    }
    return (j - i) / 2;
}


伪代码
// for i from 0 through n - 1
//      for r that makes both i - r and i + r in range 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
//           if charAt(i - r) != charAt(i + r) break;
//           count++;

// for i from 0 though n - 2
//      for r that makes both i - r and i + 1 + r in range
//           if charAt(i - r) == charAt(i + 1 + r) break
//           count++;

// return count;


*******变种*******
输出所有回文子串，
在下述代码里改一下即可

public String longestPalindrome(String s) {
    int start = 0, end = 0;
    for (int i = 0; i < s.length() - 1; i++) {
        int len1 = expandPalindrome(s, i, i);
        int len2 = expandPalindrome(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}


