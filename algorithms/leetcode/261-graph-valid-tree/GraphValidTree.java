class Solution {
  public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) {
      return false;
    }

    int[] id = new int[n];
    Arrays.fill(id, -1);

    for (int i = 0; i < edges.length; i++) {
      int start = root(edges[i][0], id);
      int end = root(edges[i][1], id);

      if (start == end) {
        return false;
      }

      id[start] = end;
    }

    return true;
  }

  private int root(int i, int[] id) {
    if (id[i] == -1) {
      return i;
    }

    while (id[i] != -1) {
      i = id[i];
    }

    return i;
  }
}
