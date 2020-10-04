


}49. Group Anagrams

Solution 1: hash+counting sort

O(mn) time, O(m) space, m is the num of strs, n is the length of strs

public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, ArrayList<String>> map = new HashMap<>();
    for (String s : strs) {
        int[] count = new int[26]; //cuz inputs are lowercase letters, we only need 26
        for (int i = 0; i < s.length(); i++) 
            count[s.charAt(i) - 'a']++;
        String anagram = "";//build a string key, eg."aabcccdd" -> 2a1b3c2d
        for (int i = 0; i < count.length; i++) 
            if (count[i] != 0) 
                anagram += String.valueOf(count[i]) + String.valueOf((char)('a' + i));
        if (!map.containsKey(anagram)) 
            map.put(anagram, new ArrayList<>());
        map.get(anagram).add(s);
    }
    return new ArrayList<List<String>>(map.values());
}



Solution 2: hash + sort

O(mnlogn) time, O(m) space, m is the num of strs, n is the length of strs

public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] chrs = s.toCharArray();
        Arrays.sort(chrs);
        String t = new String(chrs);
        if (!map.containsKey(t))    map.put(t, new ArrayList<>());
        map.get(t).add(s);
    }
    return new ArrayList<List<String>>(map.values());
}