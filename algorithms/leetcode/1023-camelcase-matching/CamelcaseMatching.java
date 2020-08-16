class Solution {
    private boolean match(String query, String pattern) {
        int pn = pattern.length();
        int j = 0;
        for (int i = 0; i < query.length(); i++) {
            if (j < pn && query.charAt(i) == pattern.charAt(j)) {
                j++;
            } else if (query.charAt(i) >= 'A' && query.charAt(i) <= 'Z') {
                return false;
            }
        }
        
        return j == pn;
    }
    
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int nq = queries.length;
        
        List<Boolean> result = new ArrayList<Boolean>(nq);
        
        for (String query : queries) {
            result.add(match(query, pattern));
        }
        
        return result;
    }
}
