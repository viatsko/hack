#include <string>

std::string characterParity(char symbol) {
  if (symbol >= '0' && symbol <= '9') {
    if ((symbol - '0') % 2 == 0) {
      return std::string("even");
    } else {
      return std::string("odd");
    }
  } else {
    return std::string("not a digit");
  }
}
