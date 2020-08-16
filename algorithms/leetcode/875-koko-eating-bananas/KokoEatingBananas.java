class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (!isValid(piles, H, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private boolean isValid(int[] piles, int H, int K) {
        for (int pile : piles) {
            H -= (pile % K > 0 ? 1 : 0) + (pile / K);
        }
        
        return H >= 0;
    }
}
