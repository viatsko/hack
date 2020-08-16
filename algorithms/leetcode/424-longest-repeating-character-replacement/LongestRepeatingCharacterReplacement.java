class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] chars = new int[26];
        int maxUnique = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            chars[ch - 'A']++;
            maxUnique = Math.max(maxUnique, chars[ch - 'A']);
            
            int replacesNeeded = i - left + 1 - maxUnique;
            
            if (replacesNeeded > k) {
                chars[s.charAt(left++) - 'A']--;
            } else {
                result = Math.max(i - left + 1, result);
            }
        }
        return result;
    }
}
