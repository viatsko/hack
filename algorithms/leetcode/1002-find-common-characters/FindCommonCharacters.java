class Solution {
    private int[] calculateNewCommon(String str, int[] prevCommon) {
        int[] common = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'a';
            if (prevCommon[ch] > 0) {
                common[ch]++;
                prevCommon[ch]--;
            }
        }
        
        return common;
    }
    
    public List<String> commonChars(String[] A) {
        int[] common = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            common[A[0].charAt(i) - 'a']++;
        }
        
        for (int i = 1; i < A.length; i++) {
            common = calculateNewCommon(A[i], common);
        }
        
        List<String> result = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            while (common[i] > 0) {
                result.add(Character.toString((char)('a' + i)));
                common[i]--;
            }
        }
        
        return result;
    }
}
