#include <string>
#include <vector>

class Solution {
public:
    std::vector<int> numberOfLines(std::vector<int>& widths, std::string s) {
      int lines = 0;

      int cur_len = 0;
      for (char const& ch : s) {
        int width = widths[ch - 'a'];

        if (cur_len + width > 100) {
          lines++;
          cur_len = width;
        } else {
          cur_len += width;
        }
      }

      if (cur_len != 0) lines++;

      return std::vector<int>{lines, cur_len};
    }
};
