#include <unordered_set>
#include <vector>
using namespace std;

class Solution {
public:
    inline size_t key(int i, int j){
        return (size_t) i << 32 | (unsigned int) j;
    }

    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        unordered_set<size_t> obs;

        int dirs[4][2] = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        for (auto obstacle : obstacles) {
            obs.insert(key(obstacle[0], obstacle[1]));
        }

        /*
            -2: turn left 90 degrees
            -1: turn right 90 degrees
             1 <= x <= 9: move forward x units
         */

        int x = 0;
        int y = 0;
        int dir = 0;
        int result = 0;
        for (auto command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            } else {
                while (command-- > 0) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    if (obs.find(key(nx, ny)) == obs.end()) {
                        result = max(result, nx * nx + ny * ny);
                        x = nx;
                        y = ny;
                    }
                }
            }
        }

        return result;
    }
};
