#include <string>
#include <set>

bool palindromeRearranging(std::string inputString) {
    std::set<char> chars;
    
    for(char const& ch: inputString) {
        if (chars.find(ch) != chars.end()) {
            chars.erase(ch);
        } else {
            chars.insert(ch);
        }
    }
    
    return chars.size() <= 1;
}
