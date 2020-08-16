class Solution {
    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        
        int left = 0;
        int right = S.length() - 1;
        
        while (left < right) {
            while (left < right && !isLetter(chars[left])) {
                left++;
            }
            while (left < right && !isLetter(chars[right])) {
                right--;
            }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
}
