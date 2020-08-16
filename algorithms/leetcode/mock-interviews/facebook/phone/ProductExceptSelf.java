class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int product = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product *= nums[i];
        }
        
        return answer;
    }
}
