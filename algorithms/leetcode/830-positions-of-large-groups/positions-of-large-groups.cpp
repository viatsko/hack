#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> largeGroupPositions(string S) {
        vector<vector<int>> result;

        for (string::size_type i = 0; i < S.size(); i++) {
            int start = i, end = i;
            char ch = S[i];

            while (S[i + 1] == ch) {
                end++;
                i++;
            }

            if (end - start >= 2) {
                vector<int> interval = {start, end};
                result.push_back(interval);
            }
        }

        return result;
    }
};
