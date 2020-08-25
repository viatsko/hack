class Solution {
  public boolean threeConsecutiveOdds(int[] arr) {
    int cons = 0;

    for (int i = 2; i < arr.length; i++) {
      if (arr[i] % 2 == 1 && arr[i - 1] % 2 == 1 && arr[i - 2] % 2 == 1) {
        return true;
      }
    }

    return false;
  }
}
