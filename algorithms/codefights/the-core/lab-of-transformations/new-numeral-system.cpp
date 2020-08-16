#include <sstream>
#include <string>
#include <vector>

std::vector<std::string> newNumeralSystem(char number) {
  std::vector<std::string> result;

  for (unsigned int i = 0; i < (number - 'A') / 2 + 1; i++) {
    char left = 'A' + i;
    char right = number - i;

    std::ostringstream oss;
    oss << left << " + " << right;

    result.push_back(oss.str());
  }

  return result;
}
