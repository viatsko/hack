#include <map>
#include <string>

bool isBeautifulString(std::string inputString) {
  std::map<char, int> chars;

  for (char const& ch : inputString) {
    chars[ch]++;
  }

  for (char ch = 'b'; ch <= 'z'; ch++) {
    if (chars[ch - 1] < chars[ch]) {
      return false;
    }
  }

  return true;
}
