#include <algorithm>
#include <iostream>
#include <vector>

// C++11 lest unit testing framework
#include "../vendor/lest.hpp"

int coinChange(const std::vector<int>& coins, int amount) {
  std::vector<int> dp(amount + 1, 0);
  dp[0] = 1;

  for (const int& coin : coins)  {
    for (int i = coin; i <= amount; i++) {
      dp[i] += dp[i - coin];
    }
  }

  return dp[amount];
}

const lest::test coinChangeTests[] = {
  CASE("amount = 4, coins = [1, 2, 5], output = 4"){
    int actual = coinChange(std::vector<int>{1, 2, 3}, 4);
    int expected = 4;
    EXPECT(actual == expected);
  },
  CASE("amount = 5, coins = [1, 2, 5], output = 4"){
    int actual = coinChange(std::vector<int>{1, 2, 5}, 5);
    int expected = 4;
    EXPECT(actual == expected);
  },
  CASE("amount = 3, coins = [2], output = 0"){
    int actual = coinChange(std::vector<int>{2}, 3);
    int expected = 0;
    EXPECT(actual == expected);
  },
  CASE("amount = 10, coins = [10], output = 1"){
    int actual = coinChange(std::vector<int>{10}, 10);
    int expected = 1;
    EXPECT(actual == expected);
  },
};

int main(int argc, char *argv[]) { return lest::run(coinChangeTests, argc, argv); }
