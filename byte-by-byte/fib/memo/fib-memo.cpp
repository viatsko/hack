#include <iostream>
#include <sstream>
#include <vector>

unsigned long long f(unsigned long long n,
                     std::vector<unsigned long long> &dp) {
  if (dp[n] == 0) {
    if (n <= 1) {
      return n;
    }

    dp[n] = f(n - 1, dp) + f(n - 2, dp);
  }

  return dp[n];
}

unsigned long long f(unsigned long long n) {
  std::vector<unsigned long long> dp(n + 1, 0);

  return f(n, dp);
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
