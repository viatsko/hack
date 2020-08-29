class Solution {
  public String freqAlphabets(String s) {
    StringBuilder stringBuilder = new StringBuilder();

    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      if (i < (chars.length - 2) && chars[i + 2] == '#') {
        stringBuilder.append((char) ((chars[i]  - '0') * 10 + (chars[i + 1] - '0') + 'a' - 1));
        i += 2;
      } else {
        stringBuilder.append((char) (chars[i] - '0' + 'a' - 1));
      }
    }

    return stringBuilder.toString();
  }
}
