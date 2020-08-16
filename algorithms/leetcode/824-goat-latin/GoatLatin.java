class Solution {
  private boolean isVowel(char c) {
    char l = Character.toLowerCase(c);

    if (l == 'a' || l == 'e' || l == 'u' || l == 'i' || l == 'o') {
      return true;
    }

    return false;
  }

  public String toGoatLatin(String S) {
    int size = S.length();

    StringBuffer sb = new StringBuffer();

    int wordnum = 1;

    for (int i = 0; i < size; i++) {
      char c = S.charAt(i);
      char postfix = ' ';

      if (!isVowel(c)) {
        postfix = c;

        if (++i < size) {
          c = S.charAt(i);
        }
      }

      while(c != ' ' && i < size) {
        sb.append(c);

        if (++i < size) {
          c = S.charAt(i);
        }
      }

      if (postfix != ' ') {
        sb.append(postfix);
      }

      sb.append("ma");

      int j = 0;
      while(j++ < wordnum) {
        sb.append('a');
      }

      if (i < size - 1) {
        sb.append(' ');
      }

      wordnum++;
    }

    return sb.toString();
  }
}
