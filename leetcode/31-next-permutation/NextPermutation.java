class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                break;
            }
        }
        
        if (i >= 0) {
            int j;
            for (j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
        
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        
        reverse(nums, i + 1);
    }
    
    private void reverse(int[] array, int start) {
        int left = start;
        int right = array.length - 1;
        
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            
            left++;
            right--;
        }
    }
}
