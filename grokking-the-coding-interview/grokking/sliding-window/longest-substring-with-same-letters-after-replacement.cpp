using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>

class CharacterReplacement {
 public:
  static int findLength(const string& str, int k) {
    int maxLength = 0;

    unordered_map<char,int> freq;

    int windowStart = 0, windowEnd = 0, maxChar = 0;
    for (windowEnd = 0; windowEnd < str.size(); windowEnd++) {
      char rightChar = str[windowEnd];
      freq[rightChar]++;

      maxChar = max(freq[rightChar], maxChar);

      if (windowEnd - windowStart + 1 - maxChar > k) {
        char leftChar = str[windowStart];
        freq[leftChar]--;
        windowStart++;
      }

      maxLength = max(maxLength, maxChar + k);
    }

    return maxLength;
  }
};
