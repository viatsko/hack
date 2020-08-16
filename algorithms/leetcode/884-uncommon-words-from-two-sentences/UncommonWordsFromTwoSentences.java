class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> counts = new HashMap<>();
        
        for (String s : A.split(" ")) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }
        
        for (String s : B.split(" ")) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }
        
        List<String> result = new LinkedList<>();
        
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        return result.toArray(new String[0]);
    }
}
