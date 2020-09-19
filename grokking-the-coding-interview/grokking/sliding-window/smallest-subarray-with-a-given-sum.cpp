using namespace std;

#include <iostream>
#include <limits>
#include <vector>

class MinSizeSubArraySum {
 public:
  static int findMinSubArray(int S, const vector<int>& arr) {
    int result = numeric_limits<int>::max();
    int windowStart = 0, windowEnd = 0, currentSum = 0;
    for (int windowEnd = 0; windowEnd < arr.size(); windowEnd++) {
      currentSum += arr[windowEnd];
      while(currentSum >= S) {
        result = min(result, windowEnd - windowStart + 1);
        currentSum -= arr[windowStart];
        windowStart++;
      }
    }
    return result == numeric_limits<int>::max() ? 0 : result;
  }
};
