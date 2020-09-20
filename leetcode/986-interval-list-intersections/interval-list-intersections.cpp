class Solution {
public:
  vector<vector<int>> intervalIntersection(vector<vector<int>>& arr1, vector<vector<int>>& arr2) {
    vector<vector<int>> result;

    int i = 0;
    int j = 0;
    while (i < arr1.size() && j < arr2.size()) {
      if (
        (arr1[i][0] >= arr2[j][0] && arr1[i][0] <= arr2[j][1]) ||
        (arr2[j][0] >= arr1[i][0] && arr2[j][0] <= arr1[i][1])
      ) {
        result.push_back({
          max(arr1[i][0], arr2[j][0]),
          min(arr1[i][1], arr2[j][1])
        });
      }

      if (arr1[i][1] < arr2[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    return result;
  }
};
