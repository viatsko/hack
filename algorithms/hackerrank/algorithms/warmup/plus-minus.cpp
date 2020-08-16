#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <iomanip>
using namespace std;


int main() {
    int positive = 0;
    int negative = 0;
    int zero = 0;

    int n;
    cin >> n;

    int tmp;
    for (int i = 0; i < n; i++) {
        cin >> tmp;
        if (tmp > 0) {
            positive++;
        } else if (tmp < 0) {
            negative++;
        } else {
            zero++;
        }
    }

    cout << fixed << setprecision(6);
    cout << positive * 1.0 / n << endl;
    cout << negative * 1.0 / n << endl;
    cout << zero * 1.0 / n << endl;

    return 0;
}
