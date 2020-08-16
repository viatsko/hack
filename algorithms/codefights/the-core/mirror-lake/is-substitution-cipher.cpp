#include <map>
#include <set>
#include <string>

bool isSubstitutionCipher(std::string string1, std::string string2) {
  std::map<char, char> alphabet;
  std::set<char> used;

  for (std::string::size_type i = 0; i < string1.size(); i++) {
    if (alphabet.find(string1[i]) != alphabet.end()) {
      if (alphabet[string1[i]] == string2[i]) {
        continue;
      }

      return false;
    }

    if (used.find(string2[i]) != used.end()) {
      return false;
    }

    alphabet[string1[i]] = string2[i];
    used.insert(string2[i]);
  }

  return true;
}
