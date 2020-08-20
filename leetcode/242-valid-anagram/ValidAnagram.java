class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        
        Arrays.sort(sa);
        Arrays.sort(ta);
        
        return Arrays.equals(sa, ta);
    }
}
