class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& arr) {
      sort(arr.begin(), arr.end());

      vector<vector<int>> triplets;

      if (arr.size() < 3) {
        return triplets;
      }

      for (int i = 0; i < arr.size() - 2; i++) {
        if (i > 0 && arr[i] == arr[i - 1]) {
          continue;
        }

        int left = i + 1;
        int right = arr.size() - 1;

        while (left < right) {
          int sum = arr[i] + arr[left] + arr[right];
          if (sum == 0) {
            triplets.push_back({arr[i], arr[left], arr[right]});
            left++;
            right--;
            while (left < right && arr[left] == arr[left - 1]) { left++; }
            while (left < right && arr[right] == arr[right + 1]) { right--; }
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
