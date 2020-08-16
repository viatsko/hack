class Solution {
    public String minWindow(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        
        if (sn < tn) {
            return "";
        }
        
        int result = Integer.MAX_VALUE;
        String resultString = "";
        
        int found = 0; // how many characters from t are in sliding window
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < tn; i++) {
            char ch = t.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) - 1);
        }
        
        int start = 0;
        for (int i = 0; i < sn; i++) {
            char ch = s.charAt(i);
            
            if (counts.containsKey(ch)) {
                int currentOccurances = counts.get(ch) + 1;
                if (currentOccurances <= 0) {
                    found++;
                }
                counts.put(ch, currentOccurances);
            }
            
            if (found == tn) {
                for (int j = start; j < s.length(); j++) {
                    char ch2 = s.charAt(j);
                    if (counts.containsKey(ch2)) {
                        if (counts.get(ch2) == 0) {
                            break;
                        } else {
                            counts.put(ch2, counts.get(ch2) - 1);
                        }
                    }
                    
                    start++;
                }
                
                int len = i - start + 1;
                if (len < result) {
                    result = len;
                    resultString = s.substring(start, i + 1);
                }
            }
        }
        
        return resultString;
    }
}
