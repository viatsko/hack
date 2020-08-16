#include <vector>

std::vector<std::vector<int>> minesweeper(std::vector<std::vector<bool>> matrix) {
    std::vector<std::vector<int>> result;
    
    for (std::vector<std::vector<bool>>::size_type i = 0; i < matrix.size(); i++) {
        std::vector<int> row;
        
        for (std::vector<bool>::size_type j = 0; j < matrix[0].size(); j++) {
            int mines = 0;
            
            for (std::vector<std::vector<bool>>::size_type k = std::max(0, (int)i - 1); k <= std::min((int)matrix.size() - 1, (int)i + 1); k++) {
                for (std::vector<bool>::size_type l = std::max(0, (int)j - 1); l <= std::min((int)matrix[0].size() - 1, (int)j + 1); l++) {
                    if (!(k == i && l == j) && matrix[k][l]) {
                        mines++;
                    }
                }
            }
            
            row.push_back(mines);
        }
        
        result.push_back(row);
    }
    
    return result;
}
