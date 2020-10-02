class Solution {
public:
  vector<int> arrayRankTransform(vector<int> &arr) {
    vector<int> sorted(arr);

    sort(sorted.begin(), sorted.end());

    unordered_map<int, int> mp;

    for (int i = 0, rank = 1; i < sorted.size(); i++) {
      if (i > 0 && sorted[i] != sorted[i - 1])
        rank++;
      mp[sorted[i]] = rank;
    }

    vector<int> result;
    for (int num : arr) {
      result.push_back(mp[num]);
    }
    return result;
  }
};
