#include <set>
#include <sstream>
#include <string>
#include <vector>

class Solution {
public:
    int uniqueMorseRepresentations(std::vector<std::string>& words) {
      std::vector<std::string> table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
      std::set<std::string> translated;

      for (std::string const& word : words) {
        std::ostringstream oss;

        for (char const& ch : word) {
          oss << table[ch - 'a'];
        }

        translated.insert(oss.str());
      }

      return translated.size();
    }
};
