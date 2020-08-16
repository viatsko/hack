#include <string>

std::string alphabeticShift(std::string inputString) {
    for (std::string::size_type i = 0; i < inputString.size(); i++) {
        inputString[i] = inputString[i] == 'z' ? 'a' : inputString[i] + 1;
    }
    
    return inputString;
}
