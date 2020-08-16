#include <string>

class Solution {
public:
    std::string process(const std::string& str) {
        std::string result;

        for (auto c : str) {
            if (c == '#') {
                if (!result.empty()) {
                    result.pop_back();
                }
            } else {
                result.push_back(c);
            }
        }

        return result;
    }

    bool backspaceCompare(std::string s, std::string t) {
        return process(s) == process(t);
    }
};
