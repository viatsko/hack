#include <vector>

std::vector<std::vector<int>> boxBlur(std::vector<std::vector<int>> image) {
    std::vector<std::vector<int>> result;
    
    for (std::vector<std::vector<int>>::size_type i = 0; i < image.size() - 2; i++) {
        std::vector<int> row;
        
        for (std::vector<int>::size_type j = 0; j < image[0].size() - 2; j++) {
            int average = 0;
            
            for (std::vector<std::vector<int>>::size_type k = i; k < i + 3; k++) {
                for (std::vector<int>::size_type l = j; l < j + 3; l++) {
                    average += image[k][l];
                }
            }
            
            row.push_back(average / 9);
        }
        
        result.push_back(row);
    }
    
    return result;
}
