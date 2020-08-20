class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] positions = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            positions[keyboard.charAt(i) - 'a'] = i;
        }
        
        
        int answer = 0;
        int prev = 0;
        for (int i = 0; i < word.length(); i++) {
            int curr = positions[word.charAt(i) - 'a'];
            int distance = Math.abs(curr - prev);
            
            answer += distance;
            
            prev = curr;
        }
        
        return answer;
    }
}
