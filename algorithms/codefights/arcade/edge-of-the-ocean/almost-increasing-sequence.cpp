#include <climits>
#include <vector>

bool almostIncreasingSequence(std::vector<int> sequence) {
    int max = INT_MIN;
    int max2 = INT_MIN;
    int errors = 0;
    
    for (std::vector<int>::size_type i = 0; i < sequence.size(); i++) {
        if (sequence[i] > max) {
            // this will ensure we start
            // filling in max2 from second element exactly,
            // e. g. in case of 10, 1, 2, 3, 4
            // it will allow us to still consider 1 local max
            max2 = max;
            max = sequence[i];
        } else if (sequence[i] > max2) {
            max = sequence[i];
            errors++;
        } else {
            errors++;
        }
        
        if (errors > 1) {
            return false;
        }
    }
    
    return true;
}
