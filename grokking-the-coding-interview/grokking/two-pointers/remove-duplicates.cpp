using namespace std;

#include <iostream>
#include <vector>

class RemoveDuplicates {
 public:
  static int remove(vector<int>& arr) {
    int fast = 1;

    int i = 1;
    for (i = 1; fast < arr.size(); i++) {
      while(fast < arr.size() && arr[fast] == arr[i - 1]) {
        fast++;
      }
      arr[i] = arr[fast];
    }

    return i - 1;
  }
};
