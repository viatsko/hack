class Solution {
  public int maxNumberOfBalloons(String text) {
    int[] chars = new int[256];

    for (char ch : text.toCharArray()) {
      chars[ch]++;
    }

    int res = 0;

    while (true) {
      if (chars['b'] == 0) break;
      if (chars['a'] == 0) break;
      if (chars['l'] <= 1) break;
      if (chars['o'] <= 1) break;
      if (chars['n'] == 0) break;

      chars['b']--;
      chars['a']--;
      chars['l'] -= 2;
      chars['o'] -= 2;
      chars['n']--;

      res++;
    }

    return res;
  }
}
