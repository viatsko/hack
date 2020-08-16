class Solution {
    int count = 0;
    
    private void scan(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
    
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            scan(s, i, i);
            scan(s, i, i + 1);
        }
        
        return count;
    }
}
