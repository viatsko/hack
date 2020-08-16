#include <iostream>
#include <sstream>
#include <vector>

int change(int n, std::vector<int>& coins) {
  if (n == 0) {
    return 0;
  }

  int result = INT_MAX;

  for (auto coin : coins) {
    if (n - coin >= 0) {
      int curr = change(n - coin, coins);

      result = std::min(curr, result);
    }
  }

  return result + 1;
}

int main(int argc, char* argv[]) {
  std::vector<int> coins = {1, 2, 5, 10, 25};

  std::istringstream iss(argv[1]);

  int n;

  if (!(iss >> n)) {
    std::cout << "Error!" << std::endl;

    return 1;
  }

  std::cout << change(n, coins) << std::endl;

  return 0;
}
