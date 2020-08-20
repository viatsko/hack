class Solution {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int lh = height[left];
            int rh = height[right];
            max = Math.max(max, Math.min(lh, rh) * (right - left));
            
            if (lh < rh) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
}
