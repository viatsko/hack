class Solution {
    public boolean isValid(String s) {
        Stack<Character> opened = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                opened.push(')');
            } else if (ch == '{') {
                opened.push('}');
            } else if (ch == '[') {
                opened.push(']');
            } else if (opened.isEmpty() || ch != opened.pop()) {
                return false;
            }
        }
        
        return opened.size() == 0;
    }
}
