#include <string>

std::string longestDigitsPrefix(std::string inputString) {
  int prefix = 0;
  for (std::string::size_type i = 0; i < inputString.size(); prefix++, i++) {
    if (inputString[i] < '0' || inputString[i] > '9') {
      break;
    }
  }

  return inputString.substr(0, prefix);
}
