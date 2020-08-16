#include <string>

bool isMAC48Address(std::string inputString) {
    if (inputString.size() != 17) {
        return false;
    }

    for (std::string::size_type i = 0; i < inputString.size(); i++) {
        if (
            (
                (i + 1) % 3 == 0 && inputString[i] != '-'
            )
            ||
            (
                (i + 1) % 3 != 0 && !(
                    (inputString[i] >= '0' && inputString[i] <= '9') ||
                    (inputString[i] >= 'A' && inputString[i] <= 'F')
                )
            )
        ) {
            return false;
        }
    }

    return true;
}
