class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        size_t n = matrix.size();
        for (size_t i = 0; i < n / 2; i++) {
            for (size_t j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
};
