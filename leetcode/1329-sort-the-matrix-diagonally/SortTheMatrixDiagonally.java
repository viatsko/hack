class Solution {
  public int[][] diagonalSort(int[][] mat) {
    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        int index = i - j;

        List<Integer> diag = map.getOrDefault(index, new ArrayList<>());

        diag.add(mat[i][j]);

        map.put(index, diag);
      }
    }

    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      int i = 0, j = 0;
      if (entry.getKey() > 0) {
        i = entry.getKey();
      } else {
        j = -entry.getKey();
      }

      Collections.sort(entry.getValue());

      for (Integer val : entry.getValue()) {
        mat[i++][j++] = val;
      }
    }

    return mat;
  }
}
