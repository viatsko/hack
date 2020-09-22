class Solution {
public:
  int findLucky(vector<int>& arr) {
    int mp[501] = {};
    for (int num : arr) {
      mp[num]++;
    }

    for (int n = 500; n > 0; n--) {
      if (mp[n] == n) {
        return n;
      }
    }

    return -1;
  }
};
