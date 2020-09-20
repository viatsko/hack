using namespace std;

#include <algorithm>
#include <iostream>
#include <vector>

class QuadrupleSumToTarget {
 public:
  static vector<vector<int>> searchQuadruplets(vector<int> &arr, int target) {
    vector<vector<int>> quadruplets;

    sort(arr.begin(), arr.end());

    for (int i = 0; i < arr.size() - 3; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }

      for (int j = i + 1; j < arr.size() - 2; j++) {
        if ((j > i + 1) && arr[j] == arr[j - 1]) {
          continue;
        }

        int left = j + 1;
        int right = arr.size() - 1;
        while (left < right) {
          int sum = arr[i] + arr[j] + arr[left] + arr[right];
          if (sum == target) {
            quadruplets.push_back({ arr[i], arr[j], arr[left], arr[right] });
            left++;
            right--;
            while (left < right && arr[left] == arr[left - 1]) left++;
            while (left < right && arr[right] == arr[right + 1]) right--;
          } else if (sum > target) {
            right--;
          } else {
            left++;
          }
        }
      }
    }

    return quadruplets;
  }
};
