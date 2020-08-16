#include <iostream>
#include <climits>
#include <cmath>
#include <string>

int stringsConstruction(std::string a, std::string b) {
    int lettersA[26] = {};
    int lettersB[26] = {};

    for (auto ch : a) {
        lettersA[ch - 'a']++;
    }

    for (auto ch : b) {
        lettersB[ch - 'a']++;
    }

    int min = INT_MAX;
    for (std::size_t i = 0; i < 26; i++) {
        if (lettersA[i] == 0) {
          continue;
        }

        if (lettersB[i] < lettersA[i]) {
            return 0;
        }

        int current = lettersB[i] / lettersA[i];

        min = std::min(min, current);
    }

    return min;
}

int main() {
  std::cout << stringsConstruction("abc", "abc") << std::endl;
  return 0;
}
