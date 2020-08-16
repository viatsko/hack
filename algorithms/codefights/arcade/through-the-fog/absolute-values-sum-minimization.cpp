#include <vector>

int absoluteValuesSumMinimization(std::vector<int> a) {
    std::vector<int>::size_type len = a.size();

    if (len % 2 == 0) {
        int left = a[len / 2 - 1];
        int right = a[len / 2];
        return right > left ? left : right;
    } else {
        return a[len / 2];
    }
}
