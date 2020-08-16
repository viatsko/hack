class Solution {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
