using namespace std;

#include <algorithm>
#include <iostream>
#include <queue>
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

class EmployeeFreeTime {
 public:
  static vector<Interval> findEmployeeFreeTime(const vector<vector<Interval>> &schedule) {
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

int main(int argc, char *argv[]) {
  vector<vector<Interval>> input = {{{1, 3}, {5, 6}}, {{2, 3}, {6, 8}}};
  vector<Interval> result = EmployeeFreeTime::findEmployeeFreeTime(input);
  cout << "Free intervals: ";
  for (auto interval : result) {
    cout << "[" << interval.start << ", " << interval.end << "] ";
  }
  cout << endl;

  input = {{{1, 3}, {9, 12}}, {{2, 4}}, {{6, 8}}};
  result = EmployeeFreeTime::findEmployeeFreeTime(input);
  cout << "Free intervals: ";
  for (auto interval : result) {
    cout << "[" << interval.start << ", " << interval.end << "] ";
  }
  cout << endl;

  input = {{{1, 3}}, {{2, 4}}, {{3, 5}, {7, 9}}};
  result = EmployeeFreeTime::findEmployeeFreeTime(input);
  cout << "Free intervals: ";
  for (auto interval : result) {
    cout << "[" << interval.start << ", " << interval.end << "] ";
  }
}
