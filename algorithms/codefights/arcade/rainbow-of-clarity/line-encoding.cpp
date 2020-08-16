#include <string>

std::string lineEncoding(std::string s) {
    std::string result("");

    for (std::string::size_type i = 0; i < s.size(); i++) {
        std::size_t count = 1;
        char ch = s[i];

        for (std::string::size_type j = i + 1; j < s.size(); j++, i++) {
            if (s[j] != ch) {
                break;
            }

            count++;
        }

        if (count > 1) {
            result += std::to_string(count);
        }

        result += ch;
    }

    return result;
}
