class Solution {
    public String removeDuplicates(String S) {
        char[] result = new char[S.length()];
        int resultIndex = 0;
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if (resultIndex > 0) {
                char prev = result[resultIndex - 1];
                
                if (ch == prev) {
                    resultIndex--;
                    continue;
                }
            }
            
            result[resultIndex++] = ch;
        }
        
        return new String(result, 0, resultIndex);
    }
}
