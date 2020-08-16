#include <algorithm>
#include <string>
#include <vector>

class Solution {
public:
  int findMinDifference(std::vector<std::string> &timePoints) {
    std::vector<int> timePointsInt;

    for (auto timePoint : timePoints) {
      timePointsInt.push_back(((timePoint[0] - '0') * 10 + (timePoint[1] - '0')) * 60 + (timePoint[3] - '0') * 10 + (timePoint[4] - '0'));
    }

    std::sort(timePointsInt.begin(), timePointsInt.end());

    int result = INT_MAX, prev;

    for (std::vector<std::string>::size_type i = 0; i < timePoints.size(); i++) {
      int cur = timePointsInt[i];

      if (i > 0) {
        result = std::min(result, std::min(cur - prev, 1440 - cur + prev));
      }

      prev = cur;
    }

    result = std::min(result, std::min(timePointsInt[timePointsInt.size() - 1] - timePointsInt[0], 1440 - timePointsInt[timePointsInt.size() - 1] + timePointsInt[0]));

    return result;
  }
};
