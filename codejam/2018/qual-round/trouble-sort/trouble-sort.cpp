#include <iostream>
#include <string>
#include <vector>

int troubleSort(std::vector<int> v) {
  std::vector<int> odds;
  std::vector<int> evens;

  for (std::vector<int>::size_type i = 0; i < v.size(); i++) {
    if (i % 2 != 0) {
      odds.push_back(v[i]);
    } else {
      evens.push_back(v[i]);
    }
  }

  std::sort(odds.begin(), odds.end());
  std::sort(evens.begin(), evens.end());
  std::sort(v.begin(), v.end());

  for (std::vector<int>::size_type i = 0; i < v.size(); i++) {
    if (i % 2 == 0) {
      if (v[i] != evens[i / 2]) {
        return i;
      }
    } else if (v[i] != odds[i / 2]) {
      return i;
    }
  }

  return -1;
}

int main() {
  std::ios_base::sync_with_stdio (false);

  long t;

  std::cin >> t;

  for (long i = 1; i <= t; i++) {
    int n;

    std::cin >> n;

    std::vector<int> v;

    while (n-- > 0) {
      int tmp;
      std::cin >> tmp;
      v.push_back(tmp);
    }

    std::cout << "Case #" << i << ": ";

    int result = troubleSort(v);

    if (result == -1) {
      std::cout << "OK";
    } else {
      std::cout << result;
    }

    std::cout << std::endl;
  }

  return 0;
}
