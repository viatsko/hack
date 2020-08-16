#include <sstream>
#include <string>

std::string encloseInBrackets(std::string inputString) {
  std::ostringstream os;
  os << '(' << inputString << ')';
  return os.str();
}
