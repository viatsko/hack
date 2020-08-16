#include <string>

bool checkPalindrome(std::string inputString) {
    std::string::size_type i = 0;
    std::string::size_type j = inputString.size() - 1;

    while (i < j) {
        if (inputString[i] != inputString[j]) {
            return false;
        }

        i++;
        j--;
    }

    return true;
}
