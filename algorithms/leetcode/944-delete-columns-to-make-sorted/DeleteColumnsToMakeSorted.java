class Solution {
    public int minDeletionSize(String[] A) {
        int result = 0;
        
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        
        return result;
    }
}
