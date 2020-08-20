#include <iostream>
#include <vector>

int main(int argc, char * argv[]) {
  std::ios_base::sync_with_stdio (false);

  #ifdef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
  #endif

  int n, m, k;

  std::cin >> n >> m >> k;

  bool figure[50][50][50] = {{{false}}};

  for (int i = 0; i < k; i++) {
    for (int j = 0; j < n; j++) {
      std::string line;
      std::cin >> line;

      for (int k = 0; k < m; k++) {
        figure[i][j][k] = line[k] == '1';
      }
    }
  }

  int cnt = 0;
  for (int i = 1; i < k - 1; i++) {
    for (int j = 1; j < n - 1; j++) {
      for (int k = 1; k < m - 1; k++) {
        if (
          figure[i][j][k] &&
          figure[i - 1][j][k] &&
          figure[i + 1][j][k] &&
          figure[i][j - 1][k] &&
          figure[i][j + 1][k] &&
          figure[i][j][k - 1] &&
          figure[i][j][k + 1]
        ) {
          cnt++;
        }
      }
    }
  }

  std::cout << cnt << std::endl;

  return 0;
}
