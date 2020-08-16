#include <iostream>
#include <sstream>
#include <vector>

unsigned long long f(unsigned long long n) {
  std::vector<unsigned long long> dp(n + 1, 0);
  dp[0] = 0; // explicit
  dp[1] = 1;

  for (std::size_t i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
  }

  return dp[n];
}

int main(int argc, char *argv[]) {
  auto show_usage = [&argv]() {
    std::cout << "Usage: " << argv[0] << " [positive_integer]" << std::endl;
  };

  if (argc <= 1) {
    show_usage();
    return 1;
  } else {
    std::istringstream iss(argv[1]);

    unsigned long long n;

    if (!(iss >> n)) {
      show_usage();
      return 1;
    } else {
      std::cout << f(n) << std::endl;
    }
  }

  return 0;
}
