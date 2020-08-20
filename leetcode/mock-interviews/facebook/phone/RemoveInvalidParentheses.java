class Solution {
    private void dfs(String s, int pos, StringBuilder buffer, int freeL, int freeR, int opened, Set<String> result) {
        if (freeL < 0 || freeR < 0 || opened < 0 || pos > s.length()) {
            return;
        }
        
        if (pos == s.length()) {
            if (freeL == 0 && freeR == 0 && opened == 0) {
                result.add(buffer.toString());
            }
            
            return;
        }
        
        char ch = s.charAt(pos);

        if (ch == '(') {
            dfs(s, pos + 1, buffer, freeL - 1, freeR, opened, result);
            buffer.append(ch);
            dfs(s, pos + 1, buffer, freeL, freeR, opened + 1, result);
        } else if (ch == ')') {
            dfs(s, pos + 1, buffer, freeL, freeR - 1, opened, result);
            buffer.append(ch);
            dfs(s, pos + 1, buffer, freeL, freeR, opened - 1, result);
        } else {
            buffer.append(ch);
            dfs(s, pos + 1, buffer, freeL, freeR, opened, result);
        }
        
        buffer.setLength(buffer.length() - 1);
    }
    
    public List<String> removeInvalidParentheses(String s) {
        int freeL = 0;
        int freeR = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                freeL++;
            } else if (ch == ')') {
                if (freeL > 0) {
                    freeL--;
                } else {
                    freeR++;
                }
            }
        }
        
        StringBuilder buffer = new StringBuilder();
        Set<String> result = new HashSet<>();
        dfs(s, 0, buffer, freeL, freeR, 0, result);
        
        return new LinkedList<String>(result);
    }
}
