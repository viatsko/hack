class Solution {
    public int fixedPoint(int[] A) {
        int l = 0;
        int r = A.length - 1;
        
        int result = -1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] >= mid) {
                if (A[mid] == mid) {
                    result = mid;
                }
                
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return result;
    }
}
