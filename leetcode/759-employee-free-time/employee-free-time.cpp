/*
// Definition for an Interval.
class Interval {
public:
    int start;
    int end;

    Interval() {}

    Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
public:
    vector<Interval> employeeFreeTime(vector<vector<Interval>> schedule) {
      vector<Interval> allIntervals;

      for (vector<Interval> workerIntervals : schedule) {
        for (Interval interval : workerIntervals) {
          allIntervals.push_back(interval);
        }
      }

      sort(allIntervals.begin(), allIntervals.end(), [](const Interval& a, const Interval& b) {
        if (a.start == b.start) {
          return a.end < b.end;
        }

        return a.start < b.start;
      });

      vector<Interval> mergedIntervals;

      for (int i = 0; i < allIntervals.size(); i++) {
        int start = allIntervals[i].start;
        int end = allIntervals[i].end;
        while ((i < allIntervals.size() - 1) && allIntervals[i + 1].start >= start && allIntervals[i + 1].start <= end) {
          end = max(end, allIntervals[i + 1].end);
          i++;
        }
        mergedIntervals.push_back(Interval(start, end));
      }

      vector<Interval> result;

      for (int i = 0; i < mergedIntervals.size() - 1; i++) {
        result.push_back(Interval(mergedIntervals[i].end, mergedIntervals[i + 1].start));
      }

      return result;
    }
};
