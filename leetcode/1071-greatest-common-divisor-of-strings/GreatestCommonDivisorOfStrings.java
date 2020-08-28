class Solution {
  public String gcdOfStrings(String str1, String str2) {
    StringBuilder sb = new StringBuilder();

    String okPrefix = null;

    for (int i = 0; i < str1.length() && i < str2.length(); i++) {
      if (str1.charAt(i) == str2.charAt(i)) {
        sb.append(str1.charAt(i));

        String prefix = sb.toString();

        if (str1.replaceAll(prefix, "").length() == 0 && str2.replaceAll(prefix, "").length() == 0) {
          okPrefix = prefix;
        }
      } else break;
    }

    if (okPrefix != null) {
      return okPrefix;
    }

    return "";
  }
}
