#include <iostream>
#include <sstream>

unsigned long long f(unsigned long long n) {
  if (n <= 1) {
    return n;
  }

  return f(n - 1) + f(n - 2);
}

int main(int argc, char * argv[]) {
  auto show_usage = [&argv](){
    std::cout << "Usage: " << argv[0] << " [positive_integer]" << std::endl;
  };

  if (argc <= 1) {
    show_usage();
    return 1;
  } else {
    std::istringstream iss(argv[1]);

    unsigned int n;

    if (!(iss >> n)) {
      show_usage();
      return 1;
    } else {
      std::cout << f(n) << std::endl;
    }
  }

  return 0;
}
