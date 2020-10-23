class Solution {
  public int maxLengthBetweenEqualCharacters(String s) {
    int[] firstIndex = new int[26];
    Arrays.fill(firstIndex, -1);

    int largest = -1;

    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';

      if (firstIndex[index] > -1) {
        largest = Math.max(largest, i - firstIndex[index] - 1);
      } else {
        firstIndex[index] = i;
      }
    }

    return largest;
  }
}
