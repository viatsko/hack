#include <algorithm>
#include <string>

class Solution {
public:
  std::string customSortString(std::string s, std::string t) {
    int len = s.size();

    int order[26] = {26};
    std::fill_n(order, 26, len);

    for (std::string::size_type i = 0; i < len; i++) {
      order[s[i] - 'a'] = i;
    }

    std::sort(t.begin(), t.end(), [&order](char a, char b) { return order[a - 'a'] < order[b - 'a']; });

    return t;
  }
};
