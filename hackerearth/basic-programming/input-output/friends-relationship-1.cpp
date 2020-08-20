#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int n;
    cin >> n;
    while (n-- > 0) {
        int x;
        cin >> x;
        
        for (int i = 0; i < x; i++) {
            string curstr;
            for (int j = 0; j < i + 1; j++) {
                curstr.push_back('*');
            }
            for (int j = i + 1; j < x; j++) {
                curstr.push_back('#');
            }
            cout << curstr;
            reverse(curstr.begin(), curstr.end());
            cout << curstr;
            cout << endl;
        }
        
        cout << endl;
    }
    
    return 0;
}
