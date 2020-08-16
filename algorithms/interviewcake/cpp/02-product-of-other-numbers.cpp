#include <iostream>
#include <vector>

// C++11 lest unit testing framework
#include "../vendor/lest.hpp"

std::vector<int> getProductsOfAllIntsExceptAtIndex(const std::vector<int>& intVector) {
  std::vector<int> result(intVector.size(), 1);

  for (std::vector<int>::size_type i = 0; i < intVector.size() - 1; i++) {
    result[i + 1] = result[i] * intVector[i];
  }

  int product = 1;
  for (std::vector<int>::size_type i = intVector.size(); i > 0; i--) {
    result[i - 1] *= product;
    product *= intVector[i - 1];
  }

  return result;
}

// tests

const lest::test productOfOtherNumbersTests[] = {
  CASE("{1, 7, 3, 4} == {84, 12, 28, 21}") {
    std::vector<int> actual = getProductsOfAllIntsExceptAtIndex({1, 7, 3, 4});
    std::vector<int> expected = {84, 12, 28, 21};
    EXPECT(actual == expected);
  },
  CASE("{1, 2, 6, 5, 9} == {540, 270, 90, 108, 60}") {
    std::vector<int> actual = getProductsOfAllIntsExceptAtIndex({1, 2, 6, 5, 9});
    std::vector<int> expected = {540, 270, 90, 108, 60};
    EXPECT(actual == expected);
  },
};

int main(int argc, char * argv[]) {
    return lest::run(productOfOtherNumbersTests, argc, argv);
}

