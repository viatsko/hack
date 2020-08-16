#include <string>
#include <vector>

std::vector<std::string> allLongestStrings(std::vector<std::string> inputArray) {
    std::vector<std::string> result;

    std::string::size_type longest = 0;

    for (auto str : inputArray)
        longest = std::max(longest, str.size());

    for (auto str : inputArray)
        if (str.size() == longest)
            result.push_back(str);

    return result;
}
