#include <iostream>
#include <iterator>
#include <climits>
#include <cmath>
#include <vector>

#include "../../../vendor/lest.hpp"

int arrayCombinations(const std::vector<int>& v, std::size_t i, std::vector<int>& dp) {
  if (dp[i] == 0) {
    if (i == v.size()) {
      return 1;
    }

    int included = arrayCombinations(v, i + 1, dp);
    int excluded = arrayCombinations(v, i + 1, dp);

    dp[i] = included + excluded;
  }
  return dp[i];
}

int arrayCombinations(const std::vector<int>& v) {
  std::vector<int> dp(v.size() + 1, 0);
  return arrayCombinations(v, 0, dp);
}

const lest::test arrayCombinationsTests[] = {
  CASE("{} = 1") {
    std::vector<int> v;
    int actual = arrayCombinations(v);
    int expected = 1;
    EXPECT(actual == expected);
  },

  CASE("{1} = 2") {
    std::vector<int> v = { 1 };
    int actual = arrayCombinations(v);
    int expected = 2;
    EXPECT(actual == expected);
  },

  CASE("{1, 1} = 4") {
    std::vector<int> v = { 1, 1 };
    int actual = arrayCombinations(v);
    int expected = 4;
    EXPECT(actual == expected);
  },

  CASE("{1, 1, 1, 1, 1} = 32") {
    std::vector<int> v = { 1, 1, 1, 1, 1 };
    int actual = arrayCombinations(v);
    int expected = 32;
    EXPECT(actual == expected);
  },
};

int main(int argc, char * argv[]) {
  return lest::run(arrayCombinationsTests, argc, argv);
}
