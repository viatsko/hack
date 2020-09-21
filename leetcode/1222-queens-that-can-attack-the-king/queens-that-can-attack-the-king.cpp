class Solution {
public:
  vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
    bool pos[8][8] = {};
    for (const auto& queen : queens) {
      pos[queen[0]][queen[1]] = true;
    }

    vector<vector<int>> result;

    for (auto const& i : vector<int>{-1, 0, 1}) {
      for (auto const& j : vector<int>{-1, 0, 1}) {
        for (int k = 1; k < 8; k++) {
          int x = king[0] + i * k;
          int y = king[1] + j * k;
          if (x >= 0 && y >= 0 && x < 8 && y < 8 && pos[x][y]) {
            result.push_back({x, y});
            break;
          }
        }
      }
    }

    return result;
  }
};
