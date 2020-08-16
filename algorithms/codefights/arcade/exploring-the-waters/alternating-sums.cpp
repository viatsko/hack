#include <vector>

std::vector<int> alternatingSums(std::vector<int> a) {
    int firstTeam = 0;
    int secondTeam = 0;
    
    for (std::vector<int>::size_type i = 0; i < a.size(); i++) {
        if (i % 2 == 0) {
            firstTeam += a[i];
        } else {
            secondTeam += a[i];
        }
    }
    
    std::vector<int> result;
    result.push_back(firstTeam);
    result.push_back(secondTeam);
    
    return result;
}
