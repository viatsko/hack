#include <vector>

std::vector<int> arrayReplace(std::vector<int> inputArray, int elemToReplace, int substitutionElem) {
    for (std::vector<int>::size_type i = 0; i < inputArray.size(); i++) {
        if (inputArray[i] == elemToReplace) {
            inputArray[i] = substitutionElem;
        }
    }
    
    return inputArray;
}
