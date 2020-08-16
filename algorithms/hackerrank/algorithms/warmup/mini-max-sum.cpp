#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <limits>
using namespace std;


int main() {
    long min = numeric_limits<long>::max();
    long max = numeric_limits<long>::min();
    long sum = 0;

    long tmp;
    while(cin >> tmp) {
        if (tmp < min) {
            min = tmp;
        }

        if (tmp > max) {
            max = tmp;
        }

        sum += tmp;
    }

    cout << sum - max << " " << sum - min << endl;

    return 0;
}
