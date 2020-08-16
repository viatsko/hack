#include <array>
#include <climits>
#include <cmath>
#include <iostream>
#include <iterator>
#include <vector>

#include "../../../vendor/lest.hpp"

int squareSubmatrix(std::vector<std::vector<bool>> v,
                    std::vector<std::vector<bool>>::size_type i,
                    std::vector<bool>::size_type j) {
  if (i >= v.size() || j >= v[0].size() || !v[i][j]) {
    return 0;
  }

  return 1 + std::min(
    squareSubmatrix(v, i + 1, j + 1),
    std::min(
      squareSubmatrix(v, i, j + 1),
      squareSubmatrix(v, i + 1, j)
    )
  );
}

int squareSubmatrix(std::vector<std::vector<bool>> v) {
  if (v.size() == 0 || v[0].size() == 0) {
    return 0;
  }

  int result = 0;

  for (std::vector<std::vector<bool>>::size_type i = 0; i < v.size(); i++) {
    for (std::vector<bool>::size_type j = 0; j < v[0].size(); j++) {
      result = std::max(result, squareSubmatrix(v, i, j));
    }
  }

  return result;
}

const lest::test squareSubmatrixTests[] = {
    CASE("{} = 1"){
      std::vector<std::vector<bool>> v{
        {false, true, true, false, false, false, true},
        {true,  true, true, false, false, false, true},
        {true,  true, true, false, false, false, true},
        {false, true, false, false, true, true,  true},
        {false, true, false, false, true, true,  true},
        {false, true, false, false, true, false, true},
        {false, true, false, false, true, true,  true},
    };
    int actual = squareSubmatrix(v);
    int expected = 2;
    EXPECT(actual == expected);
  },
};

int main(int argc, char *argv[]) {
  return lest::run(squareSubmatrixTests, argc, argv);
}
