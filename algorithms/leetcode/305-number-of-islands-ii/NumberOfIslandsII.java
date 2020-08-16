class Solution {
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    List<Integer> result = new LinkedList<>();

    int[] id = new int[m * n];
    Arrays.fill(id, -1);

    int current = 0;

    for (int[] position : positions) {
      int x = position[0];
      int y = position[1];

      int pos = id(x, y, n);

      id[pos] = pos;

      current++;

      for (int i = 0; i < 4; i++) {
        int newX = x + dirs[i][0];
        int newY = y + dirs[i][1];

        int newPos = id(newX, newY, n);

        if (newX >= 0 && newY >= 0 && newX < m && newY < n && id[newPos] != -1) {
          int newRoot = root(newPos, id);

          if (pos != newRoot) {
            id[pos] = newRoot;
            pos = newRoot;
            current--;
          }
        }
      }

      result.add(current);
    }

    return result;
  }

  private int id(int i, int j, int n) {
    return i * n + j;
  }

  private int root(int i, int[] id) {
    while (i != id[i]) {
      i = id[i];
    }

    return i;
  }
}
