class Solution {
  // [1, 3, 5] = 2
  // [1, 3, 5, 7] = 4
  // [1, 3, 5, 7, 9] = 6
  // [1, 3, 5, 7, 9, 11] = 9
  public int minOperations(int n) {
    return n * n / 4;
  }
}
