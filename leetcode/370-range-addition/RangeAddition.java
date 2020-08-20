class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        for (int[] update : updates) {
            for (int j = update[0]; j <= update[1]; j++) {
                arr[j] += update[2];
            }
        }

        return arr;
    }
}
