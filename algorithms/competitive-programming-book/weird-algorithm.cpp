#include <bits/stdc++.h>
using namespace std;

typedef unsigned long long ull;

int main() {
        ios::sync_with_stdio(false);
        cin.tie(0);
        cout.precision(10);
        cout << fixed;

        ull x;
        cin >> x;

        cout << x << ' ';

        while (x != 1) {
                if (x % 2 == 0) {
                        x /= 2;
                } else {
                        x = x * 3 + 1;
                }

                cout << x << ' ';
        }

        return 0;
}
