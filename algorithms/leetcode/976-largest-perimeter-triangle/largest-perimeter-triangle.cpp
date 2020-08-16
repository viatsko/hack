class Solution {
public:
  int largestPerimeter(vector<int>& vec) {
    sort(vec.begin(), vec.end());

    for (int i = vec.size() - 3; i >= 0; i--) {
      if (vec[i] + vec[i + 1] > vec[i + 2]) {
        return vec[i] + vec[i + 1] + vec[i + 2];
      }
    }
    
    return 0;
  }
};
