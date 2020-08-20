class Solution {
  public boolean checkInclusion(String s1, String s2) {
    int[] s1freqs = new int[26];
    int[] s2freqs = new int[26];

    int k = s1.length();

    int n = s2.length();

    if (k > n) {
      return false;
    }

    for (int i = 0; i < k; i++) {
      s1freqs[s1.charAt(i) - 'a']++;
      s2freqs[s2.charAt(i) - 'a']++;
    }

    if (compareFreqs(s1freqs, s2freqs)) {
      return true;
    }

    for (int i = k; i < n; i++) {
      s2freqs[s2.charAt(i - k) - 'a']--;
      s2freqs[s2.charAt(i) - 'a']++;

      if (compareFreqs(s1freqs, s2freqs)) {
        return true;
      }
    }

    return false;
  }

  private boolean compareFreqs(int[] freqs1, int[] freqs2) {
    for (int i = 0; i < 26; i++) {
      if (freqs1[i] != freqs2[i]) {
        return false;
      }
    }
    return true;
  }
}
