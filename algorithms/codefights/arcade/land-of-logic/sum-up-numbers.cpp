#include <cctype>
#include <string>

int sumUpNumbers(std::string inputString) {
    int result = 0;

    for (std::string::size_type i = 0; i < inputString.size(); i++) {
        int num = 0;

        for (std::string::size_type j = i; isdigit(inputString[j]) && j < inputString.size(); i++, j++) {
            num *= 10;
            num += inputString[j] - '0';
        }

        if (num > 0) {
            result += num;
        }
    }

    return result;
}
