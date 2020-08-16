#include <climits>
#include <vector>

int adjacentElementsProduct(std::vector<int> inputArray) {
    int max = INT_MIN;
    
    for (std::vector<int>::size_type i = 0; i < inputArray.size() - 1; i++) {
        int product = inputArray[i] * inputArray[i + 1];
        if (product > max) {
            max = product;
        }
    }
    
    return max;
}
