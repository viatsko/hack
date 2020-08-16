class Solution {
    public int validSubarrays(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            sum++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= min) {
                    sum++;
                } else break;
            }
        }
        return sum;
    }
}
