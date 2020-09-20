using namespace std;

#include <algorithm>
#include <iostream>
#include <vector>

class Interval {
 public:
  int start;
  int end;

  Interval(int start, int end) {
    this->start = start;
    this->end = end;
  }
};

class ConflictingAppointments {
 public:
  static bool canAttendAllAppointments(vector<Interval>& intervals) {
    sort(intervals.begin(), intervals.end(), [](const Interval& a, const Interval& b) {
      if (a.start == b.start) {
        return a.end < b.end;
      }
      return a.start < b.start;
    });

    for (int i = 0; i < intervals.size() - 1; i++) {
      if (intervals[i + 1].start <= intervals[i].end && intervals[i + 1].start >= intervals[i].start) {
        return false;
      }
    }

    return true;
  }
};

int main(int argc, char* argv[]) {
  vector<Interval> intervals = {{1, 4}, {2, 5}, {7, 9}};
  bool result = ConflictingAppointments::canAttendAllAppointments(intervals);
  cout << "Can attend all appointments: " << result << endl;

  intervals = {{6, 7}, {2, 4}, {8, 12}};
  result = ConflictingAppointments::canAttendAllAppointments(intervals);
  cout << "Can attend all appointments: " << result << endl;

  intervals = {{4, 5}, {2, 3}, {3, 6}};
  result = ConflictingAppointments::canAttendAllAppointments(intervals);
  cout << "Can attend all appointments: " << result << endl;
}
