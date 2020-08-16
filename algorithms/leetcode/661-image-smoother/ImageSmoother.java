public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0) {
            return null;
        }

        int[][] R = new int[M.length][M[0].length];

        int n = M.length;
        int m = M[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                int count = 0;

                for (int k = Math.max(0, i - 1); k <= Math.min(n - 1, i + 1); k++) {
                    for (int l = Math.max(0, j - 1); l <= Math.min(m - 1, j + 1); l++) {
                        sum += M[k][l];
                        count++;
                    }
                }

                R[i][j] = (int) Math.floor(sum / count);
            }
        }

        return R;
    }
}
