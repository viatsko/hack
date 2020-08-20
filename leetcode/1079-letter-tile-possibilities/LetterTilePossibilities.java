class Solution {
    private static final int NUMBER_OF_LETTERS = 26;
        
    private int dfs(int[] letterCounts) {
        int total = 0;
        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
            if (letterCounts[i] > 0) {
                letterCounts[i]--;
                total++;
                total += dfs(letterCounts);
                letterCounts[i]++;
            }
        }
        return total;
    }
    
    public int numTilePossibilities(String tiles) {
        int[] letterCounts = new int[NUMBER_OF_LETTERS];
        
        for (int i = 0; i < tiles.length(); i++) {
            char ch = tiles.charAt(i);
            letterCounts[ch - 'A']++;
        }
        
        return dfs(letterCounts);
    }
}
