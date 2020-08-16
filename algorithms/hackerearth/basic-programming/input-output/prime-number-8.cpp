#include <bits/stdc++.h>
using namespace std;

void sieve(int n) {
    bool primes[n + 1];
    memset(primes, true, sizeof(primes));
    
    for (int p = 2; p * p <= n; ++p) {
        if (primes[p]) {
            for (int i = p * p; i <= n; i += p) {
                primes[i] = false;
            }
        }
    }
    
    for (int i = 2; i <= n; i++) {
        if (primes[i]) {
            cout << i << ' ';
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    sieve(n);
    
    return 0;
}
