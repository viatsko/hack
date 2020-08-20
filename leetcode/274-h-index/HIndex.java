class Solution {
  public int hIndex(int[] citations) {
    if (citations.length == 0) {
      return 0;
    }

    Arrays.sort(citations);

    int l = 0;
    int r = citations.length;

    while (l < r) {
      int m = l + (r - l) / 2;

      if (citations[m] < citations.length - m) {
        l = m + 1;
      } else {
        r = m;
      }
    }

    return citations.length - l;
  }
}
