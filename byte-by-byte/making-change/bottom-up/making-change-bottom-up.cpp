#include <iostream>
#include <sstream>
#include <vector>

int change(int n, std::vector<int>& coins) {
  std::vector<int> dp(n + 1, 0);
  dp[0] = 0; // explicit, can be skipped

  for (int i = 1; i <= n; i++) {
    int minCoins = n + 1;

    for (auto coin : coins) {
      if (i - coin >= 0) {
        minCoins = std::min(minCoins, dp[i - coin]);
      }
    }

    dp[i] = minCoins + 1;
  }

  return dp[n];
}

int main(int argc, char* argv[]) {
  std::vector<int> coins = {1, 2, 5, 10, 25};

  std::istringstream iss(argv[1]);

  int n;

  if (!(iss >> n)) {
    std::cout << "Error!" << std::endl;

    return 1;
  }

  std::cout << change(n, coins) << std::endl;

  return 0;
}
