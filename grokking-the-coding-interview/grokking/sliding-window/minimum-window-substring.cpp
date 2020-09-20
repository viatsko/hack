using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>
#include <limits>

class MinimumWindowSubstring {
 public:
  static string findSubstring(const string &str, const string &pattern) {
    unordered_map<char, int> mp;
    for (char ch : pattern) {
      mp[ch]++;
    }

    int minLength = numeric_limits<int>::max();
    string ans = "";
    int matched = 0;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str[windowEnd];
      if (mp.find(rightChar) != mp.end()) {
        mp[rightChar]--;
        if (mp[rightChar] >= 0) {
          matched++;
        }
      }

      while (matched == pattern.length()) {
        int substringLength = windowEnd - windowStart + 1;
        if (substringLength < minLength) {
          minLength = substringLength;
          ans = str.substr(windowStart, substringLength);
        }

        char leftChar = str[windowStart];
        if (mp.find(leftChar) != mp.end()) {
          if (mp[leftChar] == 0) {
            matched--;
          }
          mp[leftChar]++;
        }
        windowStart++;
      }
    }

    return ans;
  }
};
