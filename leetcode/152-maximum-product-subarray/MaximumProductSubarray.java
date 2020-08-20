class Solution {
    public int maxProduct(int[] nums) {
        int[] reversedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversedNums[i] = nums[nums.length - 1 - i];
        }
        
        int result = Math.max(nums[0], reversedNums[0]);
        for (int i = 1; i < nums.length; i++) {
            nums[i] *= nums[i - 1] != 0 ? nums[i - 1] : 1;
            reversedNums[i] *= reversedNums[i - 1] != 0 ? reversedNums[i - 1] : 1;
            result = Math.max(Math.max(nums[i], reversedNums[i]), result);
        }
        return result;
    }
}
