#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n, q;

    cin >> n >> q;

    vector<vector<int>> v(n);

    for (int i = 0; i < n; i++) {
        int k;

        cin >> k;

        for (int j = 0; j < k; j++) {
            int tmp;

            cin >> tmp;

            v[i].push_back(tmp);
        }
    }

    for (int i = 0; i < q; i++) {
        int x, y;

        cin >> x >> y;

        cout << v[x][y] << endl;
    }

    return 0;
}
