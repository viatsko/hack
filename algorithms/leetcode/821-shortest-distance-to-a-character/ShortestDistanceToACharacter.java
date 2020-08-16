class Solution {
  public int[] shortestToChar(String S, char C) {
    int size = S.length();

    int[] result = new int[size];

    int last = Integer.MIN_VALUE / 2;

    for (int i = 0; i < size; i++) {
      if (S.charAt(i) == C) {
        last = i;
      }

      result[i] = i - last;
    }

    for (int i = last - 1; i >= 0; i--) {
      if (S.charAt(i) == C) {
        last = i;
      }

      result[i] = Math.min(result[i], last - i);
    }

    return result;
  }
}
