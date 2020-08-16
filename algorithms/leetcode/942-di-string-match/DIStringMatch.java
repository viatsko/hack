class Solution {
    public int[] diStringMatch(String S) {
        int len = S.length();
        
        int left = 0;
        int right = len;
        
        int[] result = new int[len + 1];
        
        for (int i = 0; i < len; i++) {
            result[i] = S.charAt(i) == 'I' ? left++ : right--;
        }
        
        result[len] = left;
        
        return result;
    }
}
