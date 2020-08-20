#include <iostream>
#include <climits>
#include <vector>

// C++11 lest unit testing framework
#include "../vendor/lest.hpp"

int highestProductOf3(const std::vector<int>& vectorOfInts) {
  // calculate the highest product of 3 integers
  int max1 = INT_MIN;
  int max2 = INT_MIN;
  int max3 = INT_MIN;

  int min1 = INT_MAX;
  int min2 = INT_MAX;

  for (const int& num : vectorOfInts) {
    if (num > max1) {
      max3 = max2;
      max2 = max1;
      max1 = num;
    } else if (num > max2) {
      max3 = max2;
      max2 = num;
    } else if (num > max3) {
      max3 = num;
    }

    if (num < min1) {
      min2 = min1;
      min1 = num;
    } else if (num < min2) {
      min2 = num;
    }
  }

  return std::max(max1 * max2 * max3, min1 * min2 * max1);
}

const lest::test productOfOtherNumbersTests[] = {
  CASE("{1, 10, -5, 1, -100} = 5000") {
    int actual = highestProductOf3({1, 10, -5, 1, -100});
    int expected = 5000;
    EXPECT(actual == expected);
  },
  CASE("{3, 3, 3} = 27") {
    int actual = highestProductOf3({3, 3, 3});
    int expected = 27;
    EXPECT(actual == expected);
  },
  CASE("{3, 3, 3, 3} = 27") {
    int actual = highestProductOf3({3, 3, 3, 3});
    int expected = 27;
    EXPECT(actual == expected);
  },
  CASE("{3, -3, -3} = 27") {
    int actual = highestProductOf3({-3, -3, 3});
    int expected = 27;
    EXPECT(actual == expected);
  },
  CASE("{1, 2, 3} = 6") {
    int actual = highestProductOf3({1, 2, 3});
    int expected = 6;
    EXPECT(actual == expected);
  },
  CASE("{1, 2, 3, 4} = 24") {
    int actual = highestProductOf3({1, 2, 3, 4});
    int expected = 24;
    EXPECT(actual == expected);
  },
};

int main(int argc, char * argv[]) {
    return lest::run(productOfOtherNumbersTests, argc, argv);
}
