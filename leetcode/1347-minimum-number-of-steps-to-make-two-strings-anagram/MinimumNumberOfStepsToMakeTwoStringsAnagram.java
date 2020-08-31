class Solution {
  public int minSteps(String s, String t) {
    int res = 0;

    int[] chars = new int[256];

    for (char ch : s.toCharArray()) {
      chars[ch]++;
    }

    for (char ch : t.toCharArray()) {
      chars[ch]--;
    }

    for (int i = 0; i < chars.length; i++) {
      res += Math.abs(chars[i]);
    }

    return res / 2;
  }
}
