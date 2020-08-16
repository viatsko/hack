#include <string>

char firstDigit(std::string inputString) {
  std::string::size_type found = inputString.find_first_of("0123456789");

  if (found != std::string::npos) {
    return inputString[found];
  } else {
    return 0;
  }
}
