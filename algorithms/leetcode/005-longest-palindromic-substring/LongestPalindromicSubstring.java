class Solution {
    int maxLength = 0;
    String maxString = "";
    
    private void scan(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int length = right - left + 1;
            if (length > maxLength) {
                maxLength = length;
                maxString = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }
    
    public String longestPalindrome(String s) {
        if (s.length() > 0) {
            maxString = String.valueOf(s.charAt(0));
            
            for (int i = 0; i < s.length(); i++) {
                scan(s, i - 1, i + 1);
                scan(s, i, i + 1);
            }
        }
        
        return maxString;
    }
}
