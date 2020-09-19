using namespace std;

#include <iostream>
#include <unordered_map>
#include <vector>

class MaxFruitCountOf2Types {
 public:
  static int findLength(const vector<char>& arr) {
    int maxLength = 0;
    
    unordered_map<char,int> freq;
    int windowStart = 0, windowEnd = 0, sum = 0;
    for (windowEnd = 0; windowEnd < arr.size(); windowEnd++) {
      auto rightChar = arr[windowEnd];

      freq[rightChar]++;

      while (freq.size() > 2) {
        auto leftChar = arr[windowStart];
        freq[leftChar]--;
        if (freq[leftChar] == 0) {
          freq.erase(leftChar);
        }
        windowStart++;
      }

      maxLength = max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
};
