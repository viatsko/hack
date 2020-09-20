using namespace std;

#include <algorithm>
#include <iostream>
#include <vector>

class TripletSumToZero {
 public:
  static vector<vector<int>> searchTriplets(vector<int> &arr) {
    sort(arr.begin(), arr.end());

    vector<vector<int>> triplets;

    for (int i = 0; i < arr.size() - 2; i++) {
      int left = i + 1;
      int right = arr.size() - 1;

      while (left < right) {
        int sum = arr[i] + arr[left] + arr[right];
        if (sum == 0) {
          triplets.push_back({arr[i], arr[left], arr[right]});
          left++;
          right--;
        } else if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }

    return triplets;
  }
};
  
