#include <set>
#include <string>

int differentSymbolsNaive(std::string s) {
    std::set<char> chars;

    for (char const& ch : s) {
        chars.insert(ch);
    }

    return chars.size();
}
