#include <iostream>
#include <iomanip>
#include <cmath>

int main() {
  int t;
  std::cin >> t;

  for (int i = 1; i <= t; i++) {
    double a;
    std::cin >> a;

    double degree45 = M_PI / 4;
    double delta = std::acos(a * std::cos(degree45));
    double angle = delta - degree45;

    std::cout << "Case #" << i << ":" << std::endl;
    std::cout << std::setprecision(17);
    std::cout << 0.5 * std::cos(angle) << ' ' << 0.5 * std::sin(angle) << ' ' << 0.0 << std::endl;
    std::cout << -0.5 * std::sin(angle) << ' ' << 0.5 * std::cos(angle) << ' ' << 0.0 << std::endl;
    std::cout << "0.0 0.0 0.5" << std::endl;
  }

  return 0;
}
