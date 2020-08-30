class Solution {
  public List<Integer> luckyNumbers (int[][] matrix) {
    Integer[] rowMins = new Integer[matrix.length];
    Integer[] colMaxs = new Integer[matrix[0].length];

    Arrays.fill(rowMins, Integer.MAX_VALUE);
    Arrays.fill(colMaxs, 0);

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        rowMins[i] = Math.min(rowMins[i], matrix[i][j]);
        colMaxs[j] = Math.max(colMaxs[j], matrix[i][j]);
      }
    }

    Set a = new HashSet<>(Arrays.asList(rowMins));
    Set b = new HashSet<>(Arrays.asList(colMaxs));

    a.retainAll(b);

    return new ArrayList<>(a);
  }
}
