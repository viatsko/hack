125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Test: 
"" -> true //[加分项：问面试官""应该返回什么]

public boolean isPalindrome(String s) {
	// if (s.equals(""))  return true;
    char[] chs = s.toCharArray();
    int left = 0, right = s.length() - 1;
    while (left <= right) {
        while (left < right && !Character.isLetterOrDigit(chs[left])) 
            left++;
        while (left < right && !Character.isLetterOrDigit(chs[right])) 
            right--;
        if (Character.toLowerCase(chs[left++]) != Character.toLowerCase(chs[right--]))
            return false;
    }
    return true;
}