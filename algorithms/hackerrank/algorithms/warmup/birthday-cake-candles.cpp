#include <climits>
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

int main() {
    int32_t n;

    std::cin >> n;

    int32_t max_number = INT32_MIN;
    int32_t max_count = 0;

    for (int32_t i = 0; i < n; i++) {
        int tmp;

        std::cin >> tmp;

        if (tmp > max_number) {
            max_number = tmp;
            max_count = 1;
        } else if (tmp == max_number) {
            max_count++;
        }
    }

    std::cout << max_count << std::endl;


    return 0;
}
