#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

int main() {
    int n;

    std::cin >> n;

    for (int i = 0; i < n; i++) {
        int tmp;

        std::cin >> tmp;

        if (tmp < 38) {
            std::cout << tmp << std::endl;
        } else {
            int closest = std::ceil(tmp / 5.0) * 5;

            if (std::abs(closest - tmp) < 3) {
                std::cout << closest << std::endl;
            } else {
                std::cout << tmp << std::endl;
            }
        }
    }


    return 0;
}
