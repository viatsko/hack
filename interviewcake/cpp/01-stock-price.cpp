#include <iostream>
#include <climits>
#include <cmath>
#include <vector>

// C++11 lest unit testing framework
#include "../vendor/lest.hpp"

int getMaxProfit(const std::vector<int>& stockPricesYesterday) {
  if (stockPricesYesterday.size() <= 1) {
    throw std::invalid_argument("stockPricesYesterday array should have at least 2 elements");
  }

  // calculate the max profit
  int min = stockPricesYesterday[0];
  int maxProfit = INT_MIN;

  for (std::vector<int>::size_type i = 1; i < stockPricesYesterday.size(); i++) {
    int diff = stockPricesYesterday[i] - min;
    maxProfit = std::max(maxProfit, diff);
    min = std::min(min, stockPricesYesterday[i]);
  }

  return maxProfit;
}

// tests

const lest::test stockPriceTests[] = {
    CASE("price goes up then down") {
        int actual = getMaxProfit({1, 5, 3, 2});
        int expected = 4;
        EXPECT(actual == expected);
    },

    CASE("price goes down then up") {
        int actual = getMaxProfit({7, 2, 8, 9});
        int expected = 7;
        EXPECT(actual == expected);
    },

    CASE("price goes up all day") {
        int actual = getMaxProfit({1, 6, 7, 9});
        int expected = 8;
        EXPECT(actual == expected);
    },

    CASE("price goes down all day") {
        int actual = getMaxProfit({9, 7, 4, 1});
        int expected = -2;
        EXPECT(actual == expected);
    },

    CASE("price stays the same all day") {
        int actual = getMaxProfit({1, 1, 1, 1});
        int expected = 0;
        EXPECT(actual == expected);
    },

    CASE("exception with empty prices") {
        EXPECT_THROWS(getMaxProfit({}));
    },

    CASE("exception with one price") {
        EXPECT_THROWS(getMaxProfit({1}));
    },
};

int main(int argc, char * argv[])
{
    return lest::run(stockPriceTests, argc, argv);
}
