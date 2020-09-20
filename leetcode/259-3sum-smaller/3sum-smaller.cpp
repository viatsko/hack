class Solution {
public:
  int threeSumSmaller(vector<int> &arr, int target) {
    if (arr.size() < 3) {
      return 0;
    }

    sort(arr.begin(), arr.end());

    int count = 0;

    for (int i = 0; i < arr.size() - 2; i++) {
      // if (i > 0 && arr[i] == arr[i - 1]) {
      //   continue;
      // }

      int left = i + 1;
      int right = arr.size() - 1;
      while (left < right) {
        if (arr[left] + arr[right] + arr[i] < target) {
          count += right - left;
          left++;
          // while(left < right && arr[left] == arr[left - 1]) left++;
        } else {
          right--;
          // while(left < right && arr[right] == arr[right + 1]) right--;
        }
      }
    }

    return count;
  }
};
