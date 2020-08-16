#include <vector>

std::vector<int> sortByHeight(std::vector<int> a) {
    int tmp;
    
    for (std::vector<int>::size_type i = 0; i < a.size(); i++) {
        std::vector<int>::size_type min_index = i;
        
        for (std::vector<int>::size_type j = i + 1; j < a.size(); j++) {
            if (a[j] == -1) {
                continue;
            }
            
            if (a[min_index] > a[j]) {
                min_index = j;
            }
        }
        
        if (min_index != -1) {
            tmp = a[i];
            a[i] = a[min_index];
            a[min_index] = tmp;
        }
    }
    
    return a;
}
