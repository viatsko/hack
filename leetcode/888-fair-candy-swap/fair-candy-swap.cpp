class Solution {
public:
  vector<int> fairCandySwap(vector<int> &A, vector<int> &B) {
    int diff = (accumulate(A.begin(), A.end(), 0) -
                accumulate(B.begin(), B.end(), 0)) /
               2;

    unordered_set<int> st(A.begin(), A.end());

    for (int b : B)
      if (st.count(b + diff))
        return {b + diff, b};

    return {-1, -1};
  }
};
