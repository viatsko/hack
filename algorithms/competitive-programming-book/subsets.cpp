#include <bits/stdc++.h>

using namespace std;

typedef unsigned long long ull;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  ull n;
  cin >> n;

  vector<ull> current_subset;

  auto print_subset = [&]() {
    for (auto const& num : current_subset) {
      cout << num << ' ';
    }

    cout << endl;
  };

  function<void(ull)> generate_subsets = [&](ull k) -> void {
    if (k == n + 1) {
      print_subset();
    } else {
      current_subset.push_back(k);
      generate_subsets(k + 1);
      current_subset.pop_back();
      generate_subsets(k + 1);
    }
  };

  generate_subsets(1);

  return 0;
}
