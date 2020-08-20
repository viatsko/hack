#include <string>
#include <vector>

class Solution {
public:
  int maxProduct(std::vector<std::string>& words) {
    std::vector<int> words_ints(words.size(), 0);

    for (const std::string& word : words) {
      int word_int = 0;

      for (const char& ch : word) {
        word_int |= (1 << (ch - 'a'));
      }

      words_ints.push_back(word_int);
    }

    for (std::vector<std::string>::size_type i = 0; i < words.size(); i++) {
      for (std::vector<std::string>::size_type j = i + 1; j < words.size(); j++) {
        if (
          i != j &&
          words[i].size() == words[j].size() &&
          !(words_ints[i] & words_ints[j])
        ) {
          return words[i].size() * words[i].size();
        }
      }
    }

    return 0;
  }
};
