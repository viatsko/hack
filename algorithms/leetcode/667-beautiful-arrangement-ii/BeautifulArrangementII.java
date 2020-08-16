public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];

        for (int i = 0, min = 1, max = n; i < n; i++) {
            if (i < k) {
                result[i] = i % 2 != 0 ? max-- : min++;
            } else {
                result[i] = k % 2 == 0 ? max-- : min++;
            }
        }

        return result;
    }
}
