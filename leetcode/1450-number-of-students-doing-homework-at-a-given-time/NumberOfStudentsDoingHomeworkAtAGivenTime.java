class Solution {
  public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    int result = 0;
    for (int i = 0; i < startTime.length; i++) {
      if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
        result++;
      }
    }
    return result;
  }
}
