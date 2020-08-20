#include <map>
#include <set>
#include <string>
#include <vector>

class Solution {
public:
  bool areSentencesSimilar(std::vector<std::string>& words1, std::vector<std::string>& words2, std::vector<std::pair<std::string, std::string>> pairs) {
    if (words1.size() != words2.size()) {
      return false;
    }

    std::map<std::string, std::set<std::string>> mapped;

    for (std::pair<std::string, std::string> const& pair : pairs) {
      mapped[pair.first].insert(pair.second);
    }

    for (std::string::size_type i = 0; i < words1.size(); i++) {
      if (
        words1[i] != words2[i] &&
        mapped[words1[i]].find(words2[i]) == mapped[words1[i]].end() &&
        mapped[words2[i]].find(words1[i]) == mapped[words2[i]].end()
      ) {
        return false;
      }
    }

    return true;
  }
};
