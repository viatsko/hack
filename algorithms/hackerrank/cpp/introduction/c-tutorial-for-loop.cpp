//
// Created by Vilerii Iatsko on 08/01/16.
//

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int a, b;

    cin >> a >> b;

    for (int i = a; i <= b; i++) {
        if (i == 1) {
            cout << "one" << endl;
        } else if (i == 2) {
            cout << "two" << endl;
        } else if (i == 3) {
            cout << "three" << endl;
        } else if (i == 4) {
            cout << "four" << endl;
        } else if (i == 5) {
            cout << "five" << endl;
        } else if (i == 6) {
            cout << "six" << endl;
        } else if (i == 7) {
            cout << "seven" << endl;
        } else if (i == 8) {
            cout << "eight" << endl;
        } else if (i == 9) {
            cout << "nine" << endl;
        } else {
            cout << ((i % 2 == 1) ? "odd" : "even") << endl;
        }
    }

    return 0;
}
