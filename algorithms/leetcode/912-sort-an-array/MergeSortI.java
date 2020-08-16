class Solution {
    private void merge(int[] arr, int lBegin, int rBegin, int rEnd) {
        int[] result = new int[rEnd - lBegin + 1];
        
        int lEnd = rBegin - 1;
        
        int lSize = lEnd - lBegin + 1;
        int rSize = rEnd - rBegin + 1;
        
        int ri = 0;
        
        int i = 0;
        int j = 0;
        while (i < lSize && j < rSize) {
            if (arr[lBegin + i] < arr[rBegin + j]) {
                result[ri++] = arr[lBegin + i++];
            } else {
                result[ri++] = arr[rBegin + j++];
            }
        }
        
        while (i < lSize) {
            result[ri++] = arr[lBegin + i++];
        }
        
        while (j < rSize) {
            result[ri++] = arr[rBegin + j++];
        }
        
        while (ri-- > 0)
            arr[rEnd--] = result[ri];
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
