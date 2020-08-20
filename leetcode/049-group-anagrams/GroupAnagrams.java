class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String S : strs) {
            int[] chars = new int[26];
            for (int i = 0; i < S.length(); i++) {
                chars[S.charAt(i) - 'a']++;
            }
            
            String key = Arrays.toString(chars);
            
            List<String> group = groups.containsKey(key) ? groups.get(key) : new LinkedList<>();
            
            group.add(S);
            
            groups.put(key, group);
        }
        
        List<List<String>> result = new LinkedList<>();
        result.addAll(groups.values());
        return result;
    }
}
