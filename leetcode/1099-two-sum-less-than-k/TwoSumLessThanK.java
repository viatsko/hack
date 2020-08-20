class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        // i < j is irrelevant, it's more like i != j
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int max = -1;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum < K) {
                max = Math.max(sum, max);
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
