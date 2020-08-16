class Solution {
    /*
        for [3, 3, 3] by steps:
        x = 11 y = 0
        x = 0  y = 11
        x = 0  y = 0
    */
    public int singleNumber(int[] nums) {
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < nums.length; i++) {
            x = (x ^ nums[i]) & ~y;
            y = (y ^ nums[i]) & ~x;
        }
        
        return x;
    }
}
