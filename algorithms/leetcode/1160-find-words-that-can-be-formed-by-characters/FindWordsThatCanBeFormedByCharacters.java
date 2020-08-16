class Solution {
    private boolean checkWord(String word, int[] letters) {
        int[] lettersCopy = Arrays.copyOf(letters, letters.length);
            
        for (int i = 0; i < word.length(); i++) {
            if (lettersCopy[word.charAt(i) - 'a'] == 0) {
                return false;
            }
            lettersCopy[word.charAt(i) - 'a']--;
        }
        
        return true;
    }
    
    public int countCharacters(String[] words, String chars) {
        int[] letters = new int[26];
        
        for (int i = 0; i < chars.length(); i++) {
            letters[chars.charAt(i) - 'a']++;
        }
        
        int result = 0;
        for (String word : words) {
            if (checkWord(word, letters)) {
                result += word.length();
            }
        }
        return result;
    }
}
