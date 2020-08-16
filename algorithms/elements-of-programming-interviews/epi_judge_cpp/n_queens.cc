#include <algorithm>
#include <iterator>
#include <vector>
#include "test_framework/generic_test.h"
using namespace std;

vector<vector<int>> NQueens(int n) {
    vector<bool> cols(n, false);
    vector<bool> diag1(n * 2, false);
    vector<bool> diag2(n * 2, false);

    vector<vector<int>> result;

    vector<int> sequence;

    function<void(void)> helper = [&]() -> void {
        int y = (int)sequence.size();

        if (y == n) {
            vector<int> subresult;
            subresult.insert(subresult.end(), sequence.begin(), sequence.end());
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
bool Comp(vector<vector<int>>& a, vector<vector<int>>& b) {
  std::sort(std::begin(a), std::end(a));
  std::sort(std::begin(b), std::end(b));
  return a == b;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"n"};
  return GenericTestMain(args, "n_queens.cc", "n_queens.tsv", &NQueens, &Comp,
                         param_names);
}
