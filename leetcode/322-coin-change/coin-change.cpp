#include <cmath>
#include <vector>

class Solution {
public:
  int coinChange(std::vector<int>& coins, int amount) {
    std::vector<int> dp(amount + 1, amount + 1);
    dp[0] = 0;

    for (const int& coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] = std::min(dp[i], dp[i - coin] + 1);
      }
    }

    if (dp[amount] > amount) {
      return -1;
    }

    return dp[amount];
  }
};
