class Solution {
  public int[] sumZero(int n) {
    int[] result = new int[n];
    if (n % 2 == 0) {
      for (int i = 0; i < n / 2; i++) {
        result[i * 2] = i + 1;
        result[i * 2 + 1] = -(i + 1);
      }
    } else {
      result[0] = 0;
      for (int i = 0; i < n / 2; i++) {
        result[i * 2 + 1] = i + 1;
        result[i * 2 + 2] = -(i + 1);
      }
    }
    return result;
  }
}
