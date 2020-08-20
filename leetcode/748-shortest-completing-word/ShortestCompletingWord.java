class Solution {
  private boolean check(String word, int[] cnt) {
      int[] current = Arrays.copyOf(cnt, 26);

      for (int i = 0; i < word.length(); i++) {
          current[word.charAt(i) - 'a']--;
      }

      for (int freq : current) {
          if (freq > 0) {
              return false;
          }
      }

      return true;
  }

  public String shortestCompletingWord(String licensePlate, String[] words) {
      int[] cnt = new int[26];

      for (int i = 0; i < licensePlate.length(); i++) {
          char ch = Character.toLowerCase(licensePlate.charAt(i));

          if (ch >= 'a' && ch <= 'z') {
              cnt[ch - 'a']++;
          }
      }

      String result = null;

      for (String word : words) {
          if (check(word, cnt)) {
              if (result == null || word.length() < result.length()) {
                  result = word;
              }
          }
      }

      return result;
  }
}
