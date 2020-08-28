class Solution {
  public boolean differByOne(String[] dict) {
    Set<String> set = new HashSet<>();

    for (String str : dict) {
      char[] ch = str.toCharArray();

      for (int i = 0; i < ch.length; i++) {
        char currentChar = ch[i];
        ch[i] = '*';
        String variant = new String(ch);
        if (set.contains(variant)) {
          return true;
        }
        set.add(variant);
        ch[i] = currentChar;
      }
    }

    return false;
  }
}
