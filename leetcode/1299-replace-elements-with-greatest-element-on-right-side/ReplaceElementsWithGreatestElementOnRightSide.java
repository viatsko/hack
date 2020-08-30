class Solution {
  public int[] replaceElements(int[] arr) {
    int[] result = new int[arr.length];
    result[arr.length - 1] = -1;

    int runningMax = -1;
    for (int i = arr.length - 2; i >= 0; i--) {
      runningMax = Math.max(runningMax, arr[i + 1]);
      result[i] = runningMax;
    }

    return result;
  }
}
