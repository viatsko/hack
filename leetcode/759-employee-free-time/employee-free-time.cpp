#include <algorithm>
#include <vector>

struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

class Solution {
public:
  std::vector<Interval> employeeFreeTime(std::vector<std::vector<Interval>>& schedule) {
    // we can do something like merge K sorted vectors into sorted vector here,
    // but let's stick with naive approach for now
    std::vector<Interval> allIntervals;
    for (std::vector<Interval> const& workerIntervals : schedule) {
      for (Interval const& interval : workerIntervals) {
        allIntervals.push_back(interval);
      }
    }

    std::sort(allIntervals.begin(), allIntervals.end(), [](Interval const& lhs, Interval const& rhs) {
      if (lhs.start == rhs.start) {
        return lhs.end < rhs.end;
      }

      return lhs.start < rhs.start;
    });

    std::vector<Interval> result;
    for (std::vector<Interval>::size_type i = 0; i < allIntervals.size(); i++) {
      int start = allIntervals[i].start;
      int end = allIntervals[i].end;

      while (i < (allIntervals.size() - 1) && (end >= allIntervals[i + 1].start)) {
        end = std::max(allIntervals[i + 1].end, end);
        i++;
      }

      if (i < (allIntervals.size() - 1)) {
        result.push_back(Interval(end, allIntervals[i + 1].start));
      }
    }

    return result;
  }
};
