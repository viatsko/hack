using namespace std;

#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

class Meeting {
 public:
  int start = 0;
  int end = 0;

  Meeting(int start, int end) {
    this->start = start;
    this->end = end;
  }
};

class MinimumMeetingRooms {
 public:
  static int findMinimumMeetingRooms(vector<Meeting> &meetings) {
    int maxRooms = 0;

    sort(meetings.begin(), meetings.end(), [](const Meeting& a, const Meeting& b){
      if (a.start == b.start) {
        return a.end < b.end;
      }
      return a.start < b.start;
    });

    auto comp = [](const Meeting& a, const Meeting& b) {
      return a.end > b.end;
    };

    priority_queue<Meeting, vector<Meeting>, decltype(comp)> pq(comp);
    for (int i = 0; i < meetings.size(); i++) {
      while ((int)pq.size() > 0 && pq.top().end <= meetings[i].start) {
        pq.pop();
      }
      pq.push(meetings[i]);
      maxRooms = max(maxRooms, (int)pq.size());
    }

    return maxRooms;
  }
};

int main(int argc, char *argv[]) {
  vector<Meeting> input = {{4, 5}, {2, 3}, {2, 4}, {3, 5}};
  int result = MinimumMeetingRooms::findMinimumMeetingRooms(input);
  cout << "Minimum meeting rooms required: " << result << endl;

  input = {{1, 4}, {2, 5}, {7, 9}};
  result = MinimumMeetingRooms::findMinimumMeetingRooms(input);
  cout << "Minimum meeting rooms required: " << result << endl;

  input = {{6, 7}, {2, 4}, {8, 12}};
  result = MinimumMeetingRooms::findMinimumMeetingRooms(input);
  cout << "Minimum meeting rooms required: " << result << endl;

  input = {{1, 4}, {2, 3}, {3, 6}};
  result = MinimumMeetingRooms::findMinimumMeetingRooms(input);
  cout << "Minimum meeting rooms required: " << result << endl;

  input = {{4, 5}, {2, 3}, {2, 4}, {3, 5}};
  result = MinimumMeetingRooms::findMinimumMeetingRooms(input);
  cout << "Minimum meeting rooms required: " << result << endl;
}
