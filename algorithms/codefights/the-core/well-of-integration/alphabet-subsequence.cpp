#include <string>

bool alphabetSubsequence(std::string s) {
  for (std::string::size_type i = 0; i < s.size() - 1; i++)
    if (s[i] >= s[i + 1])
      return false;

  return true;
}
