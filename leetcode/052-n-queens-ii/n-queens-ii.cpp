class Solution {
public:
  int totalNQueens(int n) {
    vector<bool> cols(n, false);
    vector<bool> diag1(n * 2, false);
    vector<bool> diag2(n * 2, false);
    
    int result = 0;
    
    vector<int> sequence;
    function<void(void)> helper = [&]() -> void {
      int y = sequence.size();
      if (y == n) {
        result++;
        return;
      }
      
      for (int i = 0; i < n; i++) {
        if (cols[i] || diag1[i + y] || diag2[i - y + n - 1]) {
          continue;
        }
        
        cols[i] = diag1[i + y] = diag2[i - y + n - 1] = true;
        sequence.push_back(i);
        
        helper();
        
        cols[i] = diag1[i + y] = diag2[i - y + n - 1] = false;
        sequence.pop_back();
      }
    };
    
    helper();
    
    return result;
  }
};
