public class Solution {
  public int CountLetters(string S) {
    int answer = 0;

    for (int i = 1, j = 0; i < S.Length; i++) {
      if (S[i] != S[i - 1]) j = i;
      answer += i - j;
    }

    return answer + S.Length;
  }
}
