class Solution {
  public String generateTheString(int n) {
    if (n == 1) {
      return "a";
    } else if (n % 2 == 0) {
      StringBuilder sb = new StringBuilder();
      sb.append('a');
      for (int i = 1; i < n; i++) {
        sb.append('b');
      }
      return sb.toString();
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append("ab");
      for (int i = 2; i < n; i++) {
        sb.append('c');
      }
      return sb.toString();
    }
  }
}
