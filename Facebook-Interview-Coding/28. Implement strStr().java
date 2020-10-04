28. Implement strStr()

Time: O(mn)

public int strStr(String haystack, String needle) {
    // TLE
    // if (needle.length() == 0)     return 0;
    // for (int i = 0; i <= haystack.length(); i++) { 
    //     int j = 0;
    //     for (; j < needle.length(); j++)
    //         if (i + j >= haystack.length() || needle.charAt(j) != haystack.charAt(i + j))     break;
    //     if (j == needle.length())   return i;
    // }
    // return -1;
    // optimized
    if (needle.length() == 0)     return 0; // edge case: "",""=>0  "a",""=>0
    for (int i = 0; i <= haystack.length() - needle.length(); i++) { // possible starting points
        for (int j = 0; j < needle.length() && needle.charAt(j) == haystack.charAt(i + j); j++)
            if (j == needle.length() - 1)   return i;
    }
    return -1;
}


*******变种*******
find the first index in haystack that starts with an anagram of needle
assume only lowercase letters in strings

O(mn) time, O(m) space

public int strStr(String haystack, String needle) {
    if (needle.length() == 0)    return 0;
    int m = haystack.length(), n = needle.length();
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i <= m - n; i++) {//we use m - n to reduce time; should be <=, not < !
        String key = createKey(haystack, i, n);
        if (!map.containsKey(key)) 
            map.put(key, i);
    }
    String target = createKey(needle, 0, n);
    return map.containsKey(target) ? map.get(target) : -1;
}

private String createKey(String s, int start, int length) {
    int[] count = new int[26]; //see this as O(1) space
    for (int i = 0; i < length; i++) //O(n) time
        count[s.charAt(start + i) - 'a']++;
    String key = "";
    for (int j = 0; j < count.length; j++) //see this as O(1) time
        if (count[j] != 0) 
            key += String.valueOf(count[j]) + String.valueOf((char)('a' + j));
    return key;
}

//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=130978&fromuid=109727