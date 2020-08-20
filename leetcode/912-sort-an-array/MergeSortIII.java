class Solution {
    private void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
    
    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            
            merge(nums, l, m + 1, r);
        }
    }
    
    private void merge(int[] nums, int lBegin, int rBegin, int rEnd) {
        int lEnd = rBegin - 1;
        
        int[] result = new int[rEnd - lBegin + 1];
        int resultIndex = 0;
        
        int lSize = lEnd - lBegin + 1;
        int rSize = rEnd - rBegin + 1;
        
        while (lBegin <= lEnd && rBegin <= rEnd) {
            if (nums[lBegin] < nums[rBegin]) {
                result[resultIndex++] = nums[lBegin++];
            } else {
                result[resultIndex++] = nums[rBegin++];
            }
        }
        
        while (lBegin <= lEnd) {
            result[resultIndex++] = nums[lBegin++];
        }
        
        while (rBegin <= rEnd) {
            result[resultIndex++] = nums[rBegin++];
        }
        
        while (resultIndex-- > 0)
            nums[rEnd--] = result[resultIndex];
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        
        return nums;
    }
}
