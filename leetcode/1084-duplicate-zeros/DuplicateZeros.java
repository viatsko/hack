class Solution {
    public void duplicateZeros(int[] arr) {
        int zeroes = 0;
        for (int num : arr) {
            if (num == 0) zeroes++;
        }
        
        int lengthWithZeroes = arr.length + zeroes;
        
        for (int i = arr.length - 1, j = lengthWithZeroes - 1; i >= 0; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
                j--;
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            }
        }
    }
}