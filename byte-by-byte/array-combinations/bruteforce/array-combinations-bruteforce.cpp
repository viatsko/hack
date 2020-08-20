#include <array>
#include <iostream>
#include <iterator>
#include <climits>
#include <cmath>
#include <vector>

#include "../../../vendor/lest.hpp"

template<std::size_t SIZE>
int arrayCombinations(const std::array<int, SIZE>& arr, std::size_t i) {
  if (i == SIZE) {
    return 1;
  }

  int included = arrayCombinations(arr, i + 1);
  int excluded = arrayCombinations(arr, i + 1);

  return included + excluded;
}

template<std::size_t SIZE>
int arrayCombinations(const std::array<int, SIZE>& arr) {
  return arrayCombinations(arr, 0);
}

const lest::test arrayCombinationsTests[] = {
  CASE("{} = 1") {
    std::array<int, 0> arr;
    int actual = arrayCombinations(arr);
    int expected = 1;
    EXPECT(actual == expected);
  },

  CASE("{1} = 2") {
    std::array<int, 1> arr = { 1 };
    int actual = arrayCombinations(arr);
    int expected = 2;
    EXPECT(actual == expected);
  },

  CASE("{1, 1} = 4") {
    std::array<int, 2> arr = { 1, 1 };
    int actual = arrayCombinations(arr);
    int expected = 4;
    EXPECT(actual == expected);
  },

  CASE("{1, 1, 1, 1, 1} = 32") {
    std::array<int, 5> arr = { 1, 1, 1, 1, 1 };
    int actual = arrayCombinations(arr);
    int expected = 32;
    EXPECT(actual == expected);
  },
};

int main(int argc, char * argv[]) {
  return lest::run(arrayCombinationsTests, argc, argv);
}
