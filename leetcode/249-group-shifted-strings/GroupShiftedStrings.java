class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> resultSet = new HashMap<>();
        
        for (String str : strings) {
            resultSet.computeIfAbsent(getInitialShift(str), k -> new LinkedList<String>()).add(str);
        }
        
        List<List<String>> result = new LinkedList<>();
        result.addAll(resultSet.values());
        return result;
    }
    
    private String getInitialShift(String str) {
        int N = str.length();
        
        char firstChar = str.charAt(0);
        if (firstChar == 'a') {
            return str;
        } else {
            // rotate string
            
            int shift = firstChar - 'a';
                
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < N; i++) {
                char newChar = (char)(str.charAt(i) - shift);
                if (newChar < 'a') {
                    newChar = (char)('z' - (char)('a' - newChar) + 1);
                }
                sb.append(newChar);
            }
            
            //System.out.println("Initial " + sb.toString());
            
            return sb.toString();
        }
    }
}
