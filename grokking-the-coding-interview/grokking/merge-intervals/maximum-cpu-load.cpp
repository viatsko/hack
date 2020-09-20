using namespace std;

#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

class Job {
 public:
  int start = 0;
  int end = 0;
  int cpuLoad = 0;

  Job(int start, int end, int cpuLoad) {
    this->start = start;
    this->end = end;
    this->cpuLoad = cpuLoad;
  }
};

class MaximumCPULoad {
 public:
  static int findMaxCPULoad(vector<Job> &jobs) {
    int maxCPULoad = 0;

    sort(jobs.begin(), jobs.end(), [](const Job& a, const Job& b){
      if (a.start == b.start) {
        return a.end < b.end;
      }

      return a.start < b.start;
    });

    auto comp = [](const Job& a, const Job& b) {
      return a.start > b.start;
    };

    priority_queue<Job, vector<Job>, decltype(comp)> pq(comp);

    int currentLoad = 0;
    for (Job job : jobs) {
      while (pq.size() > 0 && job.start >= pq.top().end) {
        currentLoad -= pq.top().cpuLoad;
        pq.pop();
      }
      pq.push(job);
      currentLoad += job.cpuLoad;
      maxCPULoad = max(maxCPULoad, currentLoad);
    }

    return maxCPULoad;
  }
};

int main(int argc, char *argv[]) {
  vector<Job> input = {{1, 4, 3}, {7, 9, 6}, {2, 5, 4}};
  cout << "Maximum CPU load at any time: " << MaximumCPULoad::findMaxCPULoad(input) << endl;

  input = {{6, 7, 10}, {8, 12, 15}, {2, 4, 11}};
  cout << "Maximum CPU load at any time: " << MaximumCPULoad::findMaxCPULoad(input) << endl;

  input = {{1, 4, 2}, {3, 6, 5}, {2, 4, 1}};
  cout << "Maximum CPU load at any time: " << MaximumCPULoad::findMaxCPULoad(input) << endl;
}
