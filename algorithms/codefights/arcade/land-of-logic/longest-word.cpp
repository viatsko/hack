#include <cctype>
#include <climits>
#include <string>

std::string longestWord(std::string text) {
    std::string longest;

    int max = INT_MIN;

    for (std::string::size_type i = 0; i < text.size(); i++) {
        int start = i;
        int count = 0;

        for (std::string::size_type j = i; isalpha(text[j]) && j < text.size(); i++, j++) {
            count++;
        }

        if (count > max) {
            max = count;
            longest = text.substr(start, count);
        }
    }

    return longest;
}
