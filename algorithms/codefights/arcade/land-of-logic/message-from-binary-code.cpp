#include <string>

std::string messageFromBinaryCode(std::string code) {
    std::string result("");

    for (std::string::size_type i = 0; i < code.size(); i += 8) {
        result += (char) std::stoi(code.substr(i, 8), nullptr, 2);
    }

    return result;
}
