class Solution {
public:
  int numJewelsInStones(string J, string S) {
    bool jewels[256] = { 0 };
    for (char& ch : J) {
      jewels[ch] = true;
    }

    int result = 0;
    for (char& ch : S) {
      if (jewels[ch]) {
        result++;
      }
    }

    return result;
  }
};