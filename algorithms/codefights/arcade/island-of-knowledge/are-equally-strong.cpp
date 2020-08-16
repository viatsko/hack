#include <algorithm>

bool areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
    int your_min = std::min(yourLeft, yourRight);
    int your_max = std::max(yourLeft, yourRight);
    
    int friends_min = std::min(friendsLeft, friendsRight);
    int friends_max = std::max(friendsLeft, friendsRight);
    
    return your_min == friends_min && your_max == friends_max;
}
