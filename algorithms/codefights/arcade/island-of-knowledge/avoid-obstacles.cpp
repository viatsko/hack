#include <vector>

int avoidObstacles(std::vector<int> inputArray) {
    int maxN = 0;
    
    for (int const& obstacle : inputArray) {
        maxN = std::max(obstacle, maxN);
    }
    
    // [2, 3] = 4
    maxN += 1;
    
    for (unsigned int jumps = 2; jumps <= maxN; jumps++) {
        bool dirty = false;
        
        for (int const& obstacle : inputArray) {
            if (obstacle % jumps == 0) {
                dirty = true;
                break;
            }
        }
        
        if (!dirty) {
            return jumps;
        }
    }
    
    return -1;
}
