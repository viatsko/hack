// beats 100%/100% java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int gsum = n * (n + 1) / 2;
        
        for (int num : nums) {
            gsum -= num;
        }
        
        return gsum;
    }
}
