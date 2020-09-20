class Solution {
public:
  bool circularArrayLoop(vector<int>& arr) {
    for (int i = 0; i < arr.size(); i++) {
      bool isForward = arr[i] >= 0;

      int slow = i;
      int fast = i;

      do {
        slow = findNextIndex(arr, isForward, slow);
        fast = findNextIndex(arr, isForward, fast);
        if (fast != -1) {
          fast = findNextIndex(arr, isForward, fast);
        }
      } while (slow != -1 && fast != -1 && slow != fast);

      if (slow != -1 && slow == fast) {
        return true;
      }
    }

    return false;
  }
private:
  int findNextIndex(vector<int>& arr, bool isForward, int i) {
    bool direction = arr[i] >= 0;

    if (isForward != direction) {
      return -1;
    }

    int newIndex = (arr[i] + i + arr.size()) % arr.size();

    if (newIndex == i) {
      return -1;
    }

    return newIndex;
  }
};
