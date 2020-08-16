class Solution {
  public String largestTimeFromDigits(int[] A) {
    int[] input = new int[10];

    for (int i = 0; i < 4; i++) {
      input[A[i]]++;
    }

    for (int hours = 23; hours >= 0; hours--) {
      for (int minutes = 59; minutes >= 0; minutes--) {
        int[] c = new int[10];

        if (hours < 10) {
          c[0]++;
          c[hours]++;
        } else {
          c[hours % 10]++;
          c[hours / 10]++;
        }

        if (minutes < 10) {
          c[0]++;
          c[minutes]++;
        } else {
          c[minutes % 10]++;
          c[minutes / 10]++;
        }

        if (Arrays.equals(input, c)) {
          return String.format("%02d:%02d", hours, minutes);
        }
      }
    }

    return "";
  }
}
