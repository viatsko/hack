#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        int N = A.size();

        int result = 0;

        unordered_map<int, int> m;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                m[A[i] + B[j]]++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = -C[i] -D[j];

                if (m.find(sum) != m.end()) {
                    result += m[sum];
                }
            }
        }

        return result;
    }
};
