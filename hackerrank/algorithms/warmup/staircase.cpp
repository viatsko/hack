#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <iomanip>
using namespace std;


int main() {
    int n;
    cin >> n;

    string hash;

    for (int i = 0; i < n; i++) {
        hash += '#';
        cout << setw(n) << hash << endl;
    }

    return 0;
}
