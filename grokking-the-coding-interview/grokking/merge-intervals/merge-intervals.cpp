using namespace std;

#include <algorithm>
#include <iostream>
#include <vector>

class Interval {
 public:
  int start = 0;
  int end = 0;

  Interval(int start, int end) {
    this->start = start;
    this->end = end;
  }
};

class MergeIntervals {
 public:
  static vector<Interval> merge(vector<Interval> &intervals) {
    sort(intervals.begin(), intervals.end(), [](const Interval &a, const Interval &b) {
      if (a.start == b.start) {
        return a.end < b.end;
      }
      return a.start < b.start;
    });

    vector<Interval> mergedIntervals;

    for (int i = 0; i < (int)intervals.size(); i++) {
      int begin = intervals[i].start;
      int end = intervals[i].end;
      while (
        i < (int)(intervals.size() - 1) &&
        intervals[i + 1].start <= end
      ) {
        end = max(intervals[i].end, intervals[i + 1].end);
        i++;
      }
      mergedIntervals.push_back({begin, end});
    }

    return mergedIntervals;
  }
};

int main(int argc, char *argv[]) {
  vector<Interval> input = {{1, 3}, {2, 5}, {7, 9}};
  cout << "Merged intervals: ";
  for (auto interval : MergeIntervals::merge(input)) {
    cout << "[" << interval.start << "," << interval.end << "] ";
  }
  cout << endl;

  input = {{6, 7}, {2, 4}, {5, 9}};
  cout << "Merged intervals: ";
  for (auto interval : MergeIntervals::merge(input)) {
    cout << "[" << interval.start << "," << interval.end << "] ";
  }
  cout << endl;

  input = {{1, 4}, {2, 6}, {3, 5}};
  cout << "Merged intervals: ";
  for (auto interval : MergeIntervals::merge(input)) {
    cout << "[" << interval.start << "," << interval.end << "] ";
  }
  cout << endl;
}
