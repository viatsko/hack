class Solution {
  public int maxNumberOfApples(int[] arr) {
    Arrays.sort(arr);

    int total = 0;
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      if (total + arr[i] <= 5000) {
        total += arr[i];
        result++;
      } else {
        break;
      }
    }

    return result;
  }
}
