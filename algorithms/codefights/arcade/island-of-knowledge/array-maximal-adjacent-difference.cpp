#include <algorithm>
#include <vector>

int arrayMaximalAdjacentDifference(std::vector<int> inputArray) {
    int diff = 0;
    
    for (std::vector<int>::size_type i = 0; i < inputArray.size() - 1; i++) {
        diff = std::max(diff, std::abs(inputArray[i] - inputArray[i + 1]));
    }
    
    return diff;
}
