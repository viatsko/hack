class Solution {
  public String thousandSeparator(int n) {
    String numberString = String.valueOf(n);
    StringBuilder result = new StringBuilder();

    for (int i = numberString.length() - 1, j = 0; i >= 0; i--, j++) {
      result.append(numberString.charAt(i));
      if (j > 0 && i > 0 && j % 3 == 2) {
        result.append(".");
      }
    }

    result.reverse();

    return result.toString();
  }
}
