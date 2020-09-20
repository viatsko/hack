class Solution {
public:
  int minMeetingRooms(vector<vector<int>>& intervals) {
    int maxRooms = 0;

    sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
      if (a[0] == b[0]) {
        return a[1] < b[1];
      }

      return a[0] < b[0];
    });

    auto comp = [](const vector<int>& a, const vector<int>& b){
      return a[1] > b[1];
    };

    priority_queue<vector<int>, vector<vector<int>>, decltype(comp)> pq(comp);

    for (vector<int> interval : intervals) {
      while(pq.size() > 0 && interval[0] >= pq.top()[1]) {
        pq.pop();
      }
      pq.push(interval);
      maxRooms = max(maxRooms, (int)pq.size());
    }

    return maxRooms;
  }
};
