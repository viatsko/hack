class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] counts = new int[1001];
        
        for (int i = 0; i < A.length; i++) {
            counts[A[i]]++;
        }
        
        for (int i = 1000; i >= 0; i--) {
            if (counts[i] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
