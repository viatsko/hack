class Solution {
  public int countComponents(int n, int[][] edges) {
    int[] id = new int[n];
    Arrays.fill(id, -1);

    int count = n;

    for (int[] edge : edges) {
      int x = edge[0];
      int y = edge[1];

      int rx = find(x, id);
      int ry = find(y, id);

      if (rx != ry) {
        id[ry] = rx;
        count--;
      }
    }

    return count;
  }

  private int find(int i, int[] id) {
    while (id[i] != -1) {
      i = id[i];
    }

    return i;
  }
}
