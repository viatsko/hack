class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        if (needleLength > haystackLength) {
            return -1;
        }
        
        long haystackHash = 0;
        long needleHash = 0;
        
        final long BASE = 256L;
        long nPower = 1;
        for (int i = 0; i < needleLength; i++) {
            if (i > 0) {
                nPower = nPower * BASE;
            }
            haystackHash = haystackHash  * BASE + haystack.charAt(i);
            needleHash = needleHash * BASE + needle.charAt(i);
        }
        
        for (int i = needleLength; i < haystackLength; i++) {
            if (haystackHash == needleHash && (haystack.substring(i - needleLength, i).equals(needle))) {
                return i - needleLength;
            }
            
            haystackHash -= haystack.charAt(i - needleLength) * nPower;
            haystackHash = haystackHash * BASE + haystack.charAt(i);
        }
        
        if (haystackHash == needleHash && (haystack.substring(haystackLength - needleLength).equals(needle))) {
            return haystackLength - needleLength;
        }
        
        return -1;
    }
}
