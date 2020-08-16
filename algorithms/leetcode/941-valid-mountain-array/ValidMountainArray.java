class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        
        int left = 0;
        int right = A.length - 1;
        
        while (left < (A.length - 1) && A[left + 1] > A[left]) {
            left++;
        }
        
        while (right > 0 && A[right - 1] > A[right]) {
            right--;
        }
        
        return left > 0 && right < (A.length - 1) && left == right;
    }
}
