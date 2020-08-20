#include <iostream>
#include <iterator>
#include <climits>
#include <cmath>
#include <vector>

#include "../../../vendor/lest.hpp"

int arrayCombinations(const std::vector<int>& v) {
  std::vector<int>::size_type n = v.size();
  std::vector<int> dp(n + 1, 0);

  dp[0] = 1;

  for (std::vector<int>::size_type i = 1; i < n + 1; i++) {
    dp[i] = 2 * dp[i - 1];
  }

  return dp[n];
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
