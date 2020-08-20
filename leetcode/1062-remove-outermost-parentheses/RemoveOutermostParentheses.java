class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        
        int opened = 0;
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if (ch == '(') {
                if (opened >= 1) {
                    result.append(ch);
                }
                
                opened++;
            } else {
                opened--;
                
                if (opened >= 1) {
                    result.append(ch);
                }
            }
        }
        
        return result.toString();
    }
}