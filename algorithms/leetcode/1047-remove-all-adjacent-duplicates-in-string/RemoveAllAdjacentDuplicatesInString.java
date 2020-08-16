class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> q = new LinkedList<>();
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if (!q.isEmpty()) {
                char prev = q.peekLast();
                
                if (ch == prev) {
                    q.removeLast();
                    continue;
                }
            }
            
            q.offer(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character ch : q) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
