public class Solution {   
    public static int findLeftmostIndexOfOne(int[][] matrix) {
        int result = -1;
        for (int c = matrix[0].length - 1, r = 0; c >= 0 && r < matrix.length;) {
            if (matrix[r][c] == 1) {
                result = c;
                c--;
            } else {
                r++;
            }
        }
        return result;
    }
}
