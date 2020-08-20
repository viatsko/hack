class Solution {
    Random random = new Random();
    
    int[] nums;
    
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int result = -1;
        int shift = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            if (random.nextInt(++shift) == 0) {
                result = i;
            }
        }
        
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
