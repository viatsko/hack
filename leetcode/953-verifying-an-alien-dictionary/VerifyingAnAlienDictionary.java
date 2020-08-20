class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dictionary = new int[256];
        
        for (int i = 0; i < order.length(); i++) {
            dictionary[order.charAt(i)] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], dictionary) > 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private int compare(String str1, String str2, int[] dictionary) {
        int curr = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = 0; curr == 0 && i < len1 && i < len2; i++) {
            curr = dictionary[str1.charAt(i)] - dictionary[str2.charAt(i)];
            if (curr != 0) {
                return curr;
            }
        }
        return len1 - len2;
    }
}
