using namespace std;

#include <iostream>
#include <vector>

class CircularArrayLoop {
public:
  static bool loopExists(const vector<int> &arr) {
    for (int i = 0; i < arr.size(); i++) {
      bool isForward = arr[i] >= 0;

      int slow = 0, fast = 0;
      do {
        slow = findIndex(arr, isForward, slow);
        fast = findIndex(arr, isForward, fast);
        if (fast != -1) {
          fast = findIndex(arr, isForward, fast);
        }
      } while(slow != -1 && fast != -1 && slow != fast);

      if (slow != -1 && slow == fast) {
        return true;
      }
    }

    return false;
  }
private:
  static int findIndex(const vector<int> &arr, bool isForward, int i) {
    bool direction = arr[i] >= 0;

    if (direction != isForward) {
      return -1;
    }

    int newIndex = (arr[i] + i + arr.size()) % arr.size();

    if (newIndex == i) {
      return -1;
    }

    return newIndex;
  }
};

int main(int argc, char *argv[]) {
  cout << CircularArrayLoop::loopExists(vector<int>{1, 2, -1, 2, 2}) << endl;
  cout << CircularArrayLoop::loopExists(vector<int>{2, 2, -1, 2}) << endl;
  cout << CircularArrayLoop::loopExists(vector<int>{2, 1, -1, -2}) << endl;
}
