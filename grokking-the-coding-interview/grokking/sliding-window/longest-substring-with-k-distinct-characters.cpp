using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>

class LongestSubstringKDistinct {
 public:
  static int findLength(const string& str, int k) {
    int maxLength = 0;
    
    unordered_map<char, int> freq;
    int windowStart = 0;
    int windowEnd = 0;
    for (windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      freq[str[windowEnd]]++;
      if (freq.size() <= k) {
        maxLength = max(maxLength, windowEnd - windowStart + 1);
      }
      while (freq.size() > k) {
        freq[str[windowStart]]--;
        if (freq[str[windowStart]] == 0) {
          freq.erase(str[windowStart]);
        }
        windowStart++;
      }
    }

    return maxLength;
  }
};
