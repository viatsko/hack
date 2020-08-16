class Solution {
    private void merge(int[] arr, int lBegin, int rBegin, int rEnd) {
        int lEnd = rBegin - 1;
        
        int ri = 0;
        int n = rEnd - lBegin + 1;
        int[] result = new int[n];
        
        while (lBegin <= lEnd && rBegin <= rEnd) {
            if (arr[lBegin] < arr[rBegin]) {
                result[ri++] = arr[lBegin++];
            } else {
                result[ri++] = arr[rBegin++];
            }
        }
        
        while (lBegin <= lEnd) {
            result[ri++] = arr[lBegin++];
        }
        
        while (rBegin <= rEnd) {
            result[ri++] = arr[rBegin++];
        }
        
        while (ri-- > 0) {
            arr[rEnd - ri] = result[n - ri - 1];
        }
    }
    
    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            
            merge(arr, l, mid + 1, r);
        }
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        
        return nums;
    }
}
