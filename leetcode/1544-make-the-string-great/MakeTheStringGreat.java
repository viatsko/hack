class Solution {
  public String makeGood(String s) {
    StringBuilder sb = new StringBuilder();

    int ii = s.length();
    for (int i = 0; i < ii; i++) {
      if(i < (ii - 1) && Math.abs(
        s.charAt(i + 1) -
          s.charAt(i)
      ) == 32) {
        i++;
        continue;
      }

      sb.append(s.charAt(i));
    }

    String result = sb.toString();

    if (result.equals(s)) {
      return result;
    }

    return makeGood(result);
  }
}
