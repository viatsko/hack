#include <sstream>
#include <string>
#include <vector>

class Solution {
public:
  std::vector<std::string> fullJustify(std::vector<std::string>& words, int maxWidth) {
    std::vector<std::string> result;

    for (std::vector<std::string>::size_type i = 0, ii = words.size(); i < ii; i++) {
      std::vector<std::string>::size_type cur_size = words[i].size() + 1;

      std::vector<std::string>::size_type j;
      for (j = i + 1; j < ii; j++) {
        std::string::size_type word_size = words[j].size();

        if ((cur_size + word_size) > maxWidth) {
          break;
        }

        cur_size += word_size + 1;
      }

      std::vector<std::string>::size_type words_count = (j - i);

      cur_size -= words_count;

      std::vector<std::string>::size_type spaces = maxWidth - cur_size;

      std::ostringstream oss;
      if (j == ii) {
        std::string::size_type tmp_len = 0;

        for (std::vector<std::string>::size_type k = i; k < j; k++) {
          oss << words[k];

          tmp_len += words[k].size();

          if (k != j - 1) {
            oss << ' ';
            tmp_len += 1;
          }
        }

        tmp_len = maxWidth - tmp_len;

        while(tmp_len-- > 0) {
          oss << ' ';
        }
      } else if (words_count == 1) {
        oss << words[i];

        std::vector<std::string>::size_type additional_space_after_first_word = maxWidth - words[i].size();

        while (additional_space_after_first_word-- > 0) {
          oss << ' ';
        }
      } else {
        std::vector<std::string>::size_type space_per_word = spaces / (words_count - 1);
        std::vector<std::string>::size_type additional_space_after_first_word = spaces % (words_count - 1);
        for (std::vector<std::string>::size_type k = i; k < j; k++) {
          oss << words[k];

          if (additional_space_after_first_word > 0) {
            oss << ' ';
            additional_space_after_first_word--;
          }

          if (k != j - 1) {
            std::vector<std::string>::size_type c = space_per_word;

            while (c-- > 0) {
              oss << ' ';
            }
          }
        }
      }

      result.push_back(oss.str());

      i = j - 1;
    }

    return result;
  }
};
