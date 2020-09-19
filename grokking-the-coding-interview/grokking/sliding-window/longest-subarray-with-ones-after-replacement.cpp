using namespace std;

#include <iostream>
#include <vector>

class ReplacingOnes {
 public:
  static int findLength(const vector<int>& arr, int k) {
    int  maxLength = 0;
    int windowStart = 0, windowEnd = 0, count = 0;

    for (windowEnd = 0; windowEnd < arr.size(); windowEnd++) {
      if (arr[windowEnd] == 0) {
        count++;
      }

      while (count > k) {
        if (arr[windowStart] == 0) {
          count--;
        }
        windowStart++;
      }

      maxLength = max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
};
