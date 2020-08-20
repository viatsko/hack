class Solution {
  public boolean buddyStrings(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }

    if (A.equals(B)) {
      boolean[] chars = new boolean[26];

      for (int i = 0; i < A.length(); i++) {
        char c = A.charAt(i);

        if (chars[c - 'a']) {
          return true;
        }

        chars[c - 'a'] = true;
      }

      return false;
    } else {
      char a = 0;
      char b = 0;

      boolean swapped = false;

      for (int i = 0; i < A.length(); i++) {
        if (A.charAt(i) != B.charAt(i)) {
          if (swapped) {
            return false;
          }

          if (a == 0) {
            a = A.charAt(i);
            b = B.charAt(i);
          } else if (A.charAt(i) == b && B.charAt(i) == a) {
            swapped = true;
          } else {
            return false;
          }
        }
      }

      return true;
    }
  }
}
