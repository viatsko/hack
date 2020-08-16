#include <vector>
#include <string>

std::vector<std::string> addBorder(std::vector<std::string> picture) {
    std::vector<std::string> result;
    
    result.push_back(std::string(picture[0].size() + 2, '*'));
    
    for (const std::string& line : picture) {
        result.push_back('*' + line + '*');
    }
    
    result.push_back(std::string(picture[0].size() + 2, '*'));
    
    return result;
}
