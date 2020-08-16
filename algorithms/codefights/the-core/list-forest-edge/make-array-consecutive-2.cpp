#include <climits>
#include <vector>

int makeArrayConsecutive2(std::vector<int> statues) {
    int min = INT_MAX;
    int max = INT_MIN;
    for (int& number : statues) {
        if (number < min) {
            min = number;
        }

        if (number > max) {
            max = number;
        }
    }

    return max - min - statues.size() + 1;
}
