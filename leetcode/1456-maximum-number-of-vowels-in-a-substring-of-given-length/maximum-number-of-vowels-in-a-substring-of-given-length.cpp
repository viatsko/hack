class Solution {
public:
  bool isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }

  int maxVowels(string s, int k) {
    int maxVowels = 0;

    int vowels = 0;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
      char rightChar = s[windowEnd];
      if (isVowel(rightChar)) {
        vowels++;
      }

      maxVowels = max(maxVowels, vowels);

      if (windowEnd >= k - 1) {
        char leftChar = s[windowStart];
        if (isVowel(leftChar)) {
          vowels--;
        }
        windowStart++;
      }
    }

    return maxVowels;
  }
};
