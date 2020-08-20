class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        
        int m = matrix.length;
        
        if (m == 0) {
            return result;
        }
        
        int n = matrix[0].length;
        
        int borderLeft = 0;
        int borderRight = n - 1;
        int borderBottom = m - 1;
        int borderTop = 0;

        while (borderLeft <= borderRight && borderTop <= borderBottom) {
            for (int l = borderLeft; l <= borderRight; l++) {
                result.add(matrix[borderTop][l]);
            }
            
            borderTop++;
            
            for (int l = borderTop; l <= borderBottom; l++) {
                result.add(matrix[l][borderRight]);
            }

            borderRight--;
            
            
            if (borderTop <= borderBottom) {
                for (int l = borderRight; l >= borderLeft; l--) {
                    result.add(matrix[borderBottom][l]);
                }
            }
            
            borderBottom--;
            
            if (borderLeft <= borderRight) {
                for (int l = borderBottom; l >= borderTop; l--) {
                    result.add(matrix[l][borderLeft]);
                }
            }
            
            borderLeft++;
        }
        
        return result;
    }
}
