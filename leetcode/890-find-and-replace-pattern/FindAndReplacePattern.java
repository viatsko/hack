class Solution {
    private boolean checkWordAgainstPattern(String word, String pattern, int patternLength) {
        char[] matches = new char[256];
        char[] reverseMatches = new char[256];
        for (int i = 0; i < patternLength; i++) {
            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);

            if (matches[patternChar] > 0) {
                if (wordChar != matches[patternChar]) {
                    return false;
                }
            } else {
                if (reverseMatches[wordChar] > 0 && patternChar != reverseMatches[wordChar]) {
                    return false;
                }
                matches[patternChar] = wordChar;
                reverseMatches[wordChar] = patternChar;
            }
        }
        return true;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new LinkedList<>();
        
        int patternLength = pattern.length();
        
        for (String word: words) {
            int wordLength = word.length();
            
            if (patternLength != wordLength) {
                continue;
            }
            
            if (checkWordAgainstPattern(word, pattern, patternLength)) {
                result.add(word);
            }
        }
        
        return result;
    }
}
