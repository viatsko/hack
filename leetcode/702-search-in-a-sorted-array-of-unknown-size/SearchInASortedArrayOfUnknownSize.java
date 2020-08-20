class Solution {
  public int search(ArrayReader reader, int target) {
    int l = 0;
    int r = 2147483647;

    while (l <= r) {
      int m = l + (r - l) / 2;

      if (reader.get(m) == target) {
        return m;
      }

      if (reader.get(m) > target) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }

    return -1;
  }
}
