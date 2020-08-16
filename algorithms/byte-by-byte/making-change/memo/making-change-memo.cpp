#include <iostream>
#include <sstream>
#include <vector>

int change(int n, std::vector<int>& coins, std::vector<int>& dp) {
  if (dp[n] == 0) {
    if (n == 0) {
      return 0;
    }

    int result = INT_MAX;

    for (auto coin : coins) {
      if (n - coin >= 0) {
        int curr = change(n - coin, coins, dp);

        result = std::min(curr, result);
      }
    }

    dp[n] = result + 1;
  }

  return dp[n];
}

int change(int n, std::vector<int>& coins) {
  std::vector<int> dp(n + 1, 0);
  return change(n, coins, dp);
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
