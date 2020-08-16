#include <algorithm>
#include <climits>
#include <vector>

int arrayMaxConsecutiveSum(std::vector<int> inputArray, int k) {
    int sliding = 0;
    int max = INT_MIN;

    for (std::vector<int>::size_type i = 0; i < k; i++) {
        sliding += inputArray[i];
    }

    max = std::max(sliding, max);

    for (std::vector<int>::size_type i = 0; i < inputArray.size() - k; i++) {
        sliding -= inputArray[i];
        sliding += inputArray[i + k];

        max = std::max(sliding, max);
    }

    return max;
}
