#include <vector>

int matrixElementsSum(std::vector<std::vector<int>> matrix) {
    std::vector<bool> skip(matrix[0].size(), false);
    
    int sum = 0;
    
    for (std::vector<std::vector<int>>::size_type i = 0; i < matrix.size(); i++) {
        for (std::vector<int>::size_type j = 0; j < matrix[0].size(); j++) {
            if (!skip[j]) {
                if (matrix[i][j] == 0) {
                    skip[j] = true;
                } else {
                    sum += matrix[i][j];
                }
            }
        }
    }
    
    return sum;
}
