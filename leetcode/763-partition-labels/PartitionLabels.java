class Solution {
  public List<Integer> partitionLabels(String S) {
    int N = S.length();

    List<Integer> result = new LinkedList<>();

    int[] last = new int[26];
    for (int i = 0; i < N; i++) {
      last[S.charAt(i) - 'a'] = i;
    }

    int max = -1;
    int lastPos = 0;

    for (int i = 0; i < N; i++) {
      max = Math.max(max, last[S.charAt(i) - 'a']);

      if (i == max) {
        result.add(i - lastPos + 1);
        lastPos = i + 1;
      }
    }

    return result;
  }
}
