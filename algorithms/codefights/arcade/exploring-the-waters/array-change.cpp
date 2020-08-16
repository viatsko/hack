#include <vector>

int arrayChange(std::vector<int> inputArray) {
    int result = 0;
    
    int tmp = 0;
    
    for (std::vector<int>::size_type i = 0; i < inputArray.size() - 1; i++) {
        // slow will be increased by tmp if prev step slow was >= fast
        int slow = inputArray[i] + tmp;
        int fast = inputArray[i + 1];
        
        if (slow >= fast) {
            // difference between to elements to make array increasing
            tmp = slow - fast + 1;
            
            result += tmp;
        } else {
            // next element is greater - doing nothing
            tmp = 0;
        }
    }
    
    return result;
}
