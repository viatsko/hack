class Solution {
public:
  /*
    Observations:
    - you can only put 1 figure per column
    - you can only put 1 figure per diagonals
   */
  vector<vector<string>> solveNQueens(int n) {
    vector<bool> cols(n, false);
    vector<bool> diag1(n * 2, false);
    vector<bool> diag2(n * 2, false);
    
    vector<vector<string>> result;

    vector<int> sequence;
    function<void(void)> helper = [&]() -> void {
      int y = (int)sequence.size();
      
      if (y == n) {
        vector<string> subresult;
        
        for (int i = 0; i < n; i++) {
          string str(n, '.');
          str[sequence[i]] = 'Q';
          subresult.push_back(str);
        }
        
        result.push_back(subresult);
        
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
