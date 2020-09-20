using namespace std;

#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

class TripletSumCloseToTarget {
 public:
  static int searchTriplet(vector<int>& arr, int targetSum) {
    int closestSum = 0;
    int minDiff = numeric_limits<int>::max();

    sort(arr.begin(), arr.end());

    for (int i = 0; i < arr.size() - 2; i++) {
      int left = i + 1;
      int right = arr.size() - 1;
      while (left < right) {
        int sum = arr[left] + arr[right] + arr[i];

        if (abs(sum - targetSum) < minDiff) {
          minDiff = abs(sum - targetSum);
          closestSum = sum;
        }

        if (sum > targetSum) {
          right--;
        } else {
          left++;
        }
      }
    }

    return closestSum;
  }
};
