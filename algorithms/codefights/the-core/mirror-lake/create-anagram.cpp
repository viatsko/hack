#include <string>

int createAnagram(std::string s, std::string t) {
  int a[26] = { 0 };

  for (auto ch : s) {
    a[ch - 'A']++;
  }

  int result = 0;

  for (auto ch : t) {
    if (a[ch - 'A']-- <= 0) {
      result++;
    }
  }

  return result;
}
