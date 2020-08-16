class Solution {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int i = 0, j = A.length - 1;
        for (int resultIndex = j; resultIndex >= 0; resultIndex--) {
            if (Math.abs(A[j]) > Math.abs(A[i])) {
                result[resultIndex] = A[j] * A[j];
                j--;
            } else {
                result[resultIndex] = A[i] * A[i];
                i++;
            }
        }
        return result;
    }
}
