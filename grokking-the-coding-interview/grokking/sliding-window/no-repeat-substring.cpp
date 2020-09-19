using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>

class NoRepeatSubstring {
 public:
  static int findLength(const string& str) {
    int maxLength = 0;
    
    unordered_map<char,int> occ;
    int windowStart = 0, windowEnd = 0;
    for (windowEnd = 0; windowEnd < str.size(); windowEnd++) {
      char rightChar = str[windowEnd];
      if (occ.find(rightChar) != occ.end()) {
        windowStart = max(windowStart, occ[rightChar] + 1);
      }
      occ[rightChar] = windowEnd;
      maxLength = max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
};
