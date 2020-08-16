class Solution {
  public int binaryGap(int N) {
    int result = 0;
    int last = -1;
    int i = 0;
    while (N > 0) {
      if ((N & 1) == 1) {
        if (last > -1) {
          result = Math.max(i - last, result);
        }

        last = i;
      }

      i++;
      N = N >> 1;
    }

    return result;
  }
}
