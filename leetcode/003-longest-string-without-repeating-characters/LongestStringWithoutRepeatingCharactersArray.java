class Solution {
    public int lengthOfLongestSubstring(String S) {
        int n = S.length();
        
        if (n == 0) {
            return 0;
        }
        
        int result = 0;
        int start = 0;
        
        boolean[] chars = new boolean[256];
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if (chars[ch]) {
                while (S.charAt(start++) != ch) {
                    chars[S.charAt(start - 1)] = false;
                }
            } else {
                chars[ch] = true;
            }
            
            result = Math.max(i - start + 1, result);
        }
        
        return result;
    }
}
