#include <vector>

std::vector<int> houseOfCats(int legs) {
  std::vector<int> result;

  int people = 0;
  while (legs >= 0) {
    bool plusCat = false;
    if (legs % 4 == 2) {
      plusCat = true;
    }

    result.push_back(people + (int)plusCat);

    people += 2;
    legs -= 4;
  }

  return result;
}
