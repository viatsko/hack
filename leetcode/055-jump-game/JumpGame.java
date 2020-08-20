class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return true;
        
        int maxDistance = nums[0];
        
        for (int i = 1; i < nums.length && i <= maxDistance; i++) {
            maxDistance = Math.max(i + nums[i], maxDistance);
        }
        
        return maxDistance >= nums.length - 1;
    }
}