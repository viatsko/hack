class Solution {
    public String removeVowels(String S) {
        int vowels = 0;
        vowels |= 1 << ('a' - 'a');
        vowels |= 1 << ('e' - 'a');
        vowels |= 1 << ('i' - 'a');
        vowels |= 1 << ('o' - 'a');
        vowels |= 1 << ('u' - 'a');
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if ((vowels & 1 << (c - 'a')) == 0) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
