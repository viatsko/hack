#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n;

    cin >> n;

    int fd = 0;
    int bd = 0;

    int tmp = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> tmp;
            if (i == j) {
                fd += tmp;
            }

            if (n - i - 1 == j) {
                bd += tmp;
            }
        }
    }

    cout << abs(fd - bd) << endl;

    return 0;
}
