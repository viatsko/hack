#include <vector>
#include <set>

bool areSimilar(std::vector<int> a, std::vector<int> b) {    
    unsigned int swaps = 0;
    
    std::set<int> numbers;
    
    for (std::vector<int>::size_type i = 0; i < a.size(); i++) {
        if (a[i] != b[i]) {
            swaps++;
            numbers.insert(a[i]);
            numbers.insert(b[i]);
        }
    }
    
    return (swaps == 2 && numbers.size() == 2) || swaps == 0;
}
