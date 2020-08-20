class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        
        int left = 0;
        int right = A.length - 1;
        
        for (int num : A) {
            if (num % 2 == 0) {
                result[left++] = num;
            } else {
                result[right--] = num;
            }
        }
        
        return result;
    }
}
