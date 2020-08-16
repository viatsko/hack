class Solution {
    int currentK = 1;
    
    private String helper(boolean[] visited, int n, int k, int pos, char[] current) {
        if (pos == n) {
            if (currentK == k) {
                return new String(current);
            }
            currentK++;
            return null;
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                current[pos] = (char)('0' + i);
                String result = helper(visited, n, k, pos + 1, current);
                if (result != null) {
                    return result;
                }
                visited[i] = false;
            }
        }
        
        return null;
    }
    
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        char[] current = new char[n];
        return helper(visited, n, k, 0, current);
    }
}
