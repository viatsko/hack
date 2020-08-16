class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        
        int start = 0;
        
        Map<Character, Integer> characterToLastPosition = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (characterToLastPosition.containsKey(ch)) {
                start = Math.max(characterToLastPosition.get(ch) + 1, start);
            }
            
            characterToLastPosition.put(ch, i);
            
            result = Math.max(result, i - start + 1);
        }
        
        return result;
    }
}
