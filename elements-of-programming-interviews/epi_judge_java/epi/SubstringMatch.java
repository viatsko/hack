package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SubstringMatch {
  @EpiTest(testDataFile = "substring_match.tsv")

  // Returns the index of the first character of the substring if found, -1
  // otherwise.
  public static int rabinKarp(String t, String s) {
    int tLen = t.length();
    int sLen = s.length();

    if (tLen < sLen) {
      return -1;
    }

    final int BASE = 26;

    int tHash = 0;
    int sHash = 0;
    int sPower = 1;

    for (int i = 0; i < sLen; i++) {
      if (i > 0) sPower = sPower * BASE;
      tHash = tHash * BASE + t.charAt(i);
      sHash = sHash * BASE + s.charAt(i);
    }

    for (int i = sLen; i < tLen; i++) {
      if (tHash == sHash && t.substring(i - sLen, i).equals(s)) {
        return i - sLen;
      }

      tHash -= t.charAt(i - sLen) * sPower;
      tHash = tHash * BASE + t.charAt(i);
    }

    if (tHash == sHash && t.substring(tLen - sLen).equals(s)) {
      return tLen - sLen;
    }

    return -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest.runFromAnnotations(
                args, "SubstringMatch.java", new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
