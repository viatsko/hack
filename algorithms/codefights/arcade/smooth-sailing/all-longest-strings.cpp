#include <vector>
#include <string>

std::vector<std::string> allLongestStrings(std::vector<std::string> inputArray) {
    std::vector<std::string> result;
    std::string::size_type max = 0;
    
    for (const std::string& str : inputArray) {
        if (str.size() > max) {
            max = str.size();
        }
    }
    
    for (const std::string& str : inputArray) {
        if (str.size() == max) {
            result.push_back(str);
        }
    }
    
    return result;
}
